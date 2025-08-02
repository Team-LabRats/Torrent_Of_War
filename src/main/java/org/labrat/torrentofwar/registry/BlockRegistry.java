package org.labrat.torrentofwar.registry;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.api.FormattingUtils;
import org.labrat.torrentofwar.api.block.OresBlock;
import org.labrat.torrentofwar.api.ores.OreTypes;
import org.labrat.torrentofwar.api.ores.StoneType;
import org.labrat.torrentofwar.lang.Lang;
import org.labrat.torrentofwar.utils.KeyPair;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TorrentOfWarMod.MODID);
    public static final Object2ObjectArrayMap<KeyPair<OreTypes, StoneType>, RegistryObject<OresBlock>> ORE_BLOCKS = new Object2ObjectArrayMap<>();
    public static final Object2ObjectArrayMap<StoneType, RegistryObject<Block>> STONE_BLOCK = new Object2ObjectArrayMap<>();

    public static final BiFunction<OreTypes, StoneType, RegistryObject<OresBlock>> ORE_FUNCTION = ((oreType, stoneType) ->
            registerBlock(oreType.getId()+"_"+ stoneType.toString().toLowerCase() +"_ore",
            ()->new OresBlock(oreType,stoneType)));

    public static final Function<StoneType, RegistryObject<Block>> STONE_FUNCTION = ((stoneType) -> registerBlock(stoneType.toString(),
            ()->new Block(BlockBehaviour.Properties.of().strength(stoneType.getHardness(), stoneType.getResistance()))));

    public static void init(IEventBus modEventBus){
        for(OreTypes oreType : OreTypes.values()){
            for(StoneType stoneType : StoneType.values()){
                RegistryObject<OresBlock> block = ORE_FUNCTION.apply(oreType,stoneType);
                Lang.add(block, FormattingUtils.toEnglishName(block.getId().getPath()));
                ORE_BLOCKS.put(new KeyPair<>(oreType,stoneType), block);
            }
        }

        for(StoneType stoneType : StoneType.values()){
            if(stoneType.getBlock() != null) continue;
            RegistryObject<Block> block = STONE_FUNCTION.apply(stoneType);
            Lang.add(block, FormattingUtils.toEnglishName(block.getId().getPath()));
            STONE_BLOCK.put(stoneType, block);
        }

        BLOCKS.register(modEventBus);
    }





    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {

        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }
}
