package org.labrat.torrentofwar.registry;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.api.block.OresBlock;
import org.labrat.torrentofwar.api.ores.OreTypes;
import org.labrat.torrentofwar.api.ores.StoneType;
import org.labrat.torrentofwar.utils.KeyPair;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TorrentOfWarMod.MODID);
    public static final Object2ObjectArrayMap<KeyPair<OreTypes, StoneType>, RegistryObject<OresBlock>> ORE_BLOCKS = new Object2ObjectArrayMap<>();
    public static final Object2ObjectArrayMap<StoneType, RegistryObject<Block>> STONE_BLOCK = new Object2ObjectArrayMap<>();

    public static final BiFunction<OreTypes, StoneType, RegistryObject<OresBlock>> ORE_FUNCTION = ((oreType, stoneType) -> {
        return BLOCKS.register(oreType.getId()+"_"+ stoneType.getBlock().getDescriptionId().split("\\.")[2] +"_ore",
                ()->new OresBlock(oreType,stoneType));
    });

    public static final Function<StoneType, RegistryObject<Block>> STONE_FUNCTION = ((stoneType) -> {
        return BLOCKS.register(stoneType.toString(),
                ()->new Block(BlockBehaviour.Properties.of().strength(stoneType.getHardness(), stoneType.getResistance())));
    });
    public static void init(IEventBus modEventBus){
        for(OreTypes oreType : OreTypes.values()){
            for(StoneType stoneType : StoneType.values()){
                if(stoneType.getBlock() == null) continue;
                ORE_BLOCKS.put(new KeyPair<>(oreType,stoneType), ORE_FUNCTION.apply(oreType,stoneType));
            }
        }

        for(StoneType stoneType : StoneType.values()){
            if(stoneType.getBlock() != null) continue;
            STONE_BLOCK.put(stoneType, STONE_FUNCTION.apply(stoneType));
        }

        BLOCKS.register(modEventBus);
    }
}
