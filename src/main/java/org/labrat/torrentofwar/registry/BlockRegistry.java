package org.labrat.torrentofwar.registry;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
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

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TorrentOfWarMod.MODID);
    public static final Object2ObjectArrayMap<KeyPair<OreTypes, StoneType>, RegistryObject<OresBlock>> ORE_BLOCKS = new Object2ObjectArrayMap<>();

    public static final BiFunction<OreTypes, StoneType, RegistryObject<OresBlock>> ORE_FUNCTION = ((oreType, stoneType) -> {
        return BLOCKS.register(oreType.getId()+"_"+ stoneType.getBlock().getDescriptionId().split("\\.")[2] +"_ore",
                ()->new OresBlock(oreType,stoneType));
    });
    public static void init(IEventBus modEventBus){
        for(OreTypes oreType : OreTypes.values()){
            for(StoneType stoneType : StoneType.values()){
                String id = oreType.getId()+"_"+ stoneType.getBlock().getDescriptionId().split("\\.")[2] +"_ore";
                ORE_BLOCKS.put(new KeyPair<>(oreType,stoneType), ORE_FUNCTION.apply(oreType,stoneType));
            }
        }

        BLOCKS.register(modEventBus);
    }
}
