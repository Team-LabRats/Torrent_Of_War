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

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TorrentOfWarMod.MODID);
    public static final Object2ObjectArrayMap<String, RegistryObject<OresBlock>> ORE_BLOCKS = new Object2ObjectArrayMap<>();

    public static void init(IEventBus modEventBus){
        for(OreTypes oreType : OreTypes.values()){
            for(StoneType stoneType : StoneType.values()){
                String id = oreType.getId()+"_"+ stoneType.getBlock().getDescriptionId().split("\\.")[2] +"_ore";
                ORE_BLOCKS.put(id, BLOCKS.register(id, ()->new OresBlock(oreType,stoneType)));
            }
        }

        BLOCKS.register(modEventBus);
    }
}
