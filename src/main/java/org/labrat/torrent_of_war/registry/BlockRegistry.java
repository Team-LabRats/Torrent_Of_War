package org.labrat.torrent_of_war.registry;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.labrat.torrent_of_war.TorrentOfWarMod;
import org.labrat.torrent_of_war.api.block.OresBlock;
import org.labrat.torrent_of_war.api.ores.OreTypes;
import org.labrat.torrent_of_war.api.ores.StoneType;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TorrentOfWarMod.MODID);
    public static final Object2ObjectArrayMap<String, RegistryObject<OresBlock>> ORE_BLOCKS = new Object2ObjectArrayMap<>();

    public static void init(IEventBus modEventBus){
        for(OreTypes oreType : OreTypes.values()){
            for(StoneType stoneType : StoneType.values()){
                String id = oreType.getId()+"_"+stoneType.getBlock().getDescriptionId()+"_ore";
                ORE_BLOCKS.put(id, BLOCKS.register(id, ()->new OresBlock(oreType,stoneType)));
            }
        }

        BLOCKS.register(modEventBus);
    }
}
