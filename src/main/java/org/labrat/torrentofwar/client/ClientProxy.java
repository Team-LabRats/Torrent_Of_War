package org.labrat.torrentofwar.client;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;
import org.labrat.torrentofwar.api.block.OresBlock;
import org.labrat.torrentofwar.api.ores.OreTypes;
import org.labrat.torrentofwar.api.ores.StoneType;
import org.labrat.torrentofwar.server.CommonProxy;
import org.labrat.torrentofwar.server.registry.BlockRegistry;
import org.labrat.torrentofwar.utils.KeyPair;

import java.util.Map;

public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public void registerItemColors(RegisterColorHandlersEvent.Item event){

        for(Map.Entry<StoneType, RegistryObject<Block>> entry : BlockRegistry.STONE_BLOCK.entrySet()){
            event.register((stack, index) -> entry.getKey().getColor(index), entry.getValue().get());
        }
        for(Map.Entry<KeyPair<OreTypes, StoneType>, RegistryObject<OresBlock>> entry : BlockRegistry.ORE_BLOCKS.entrySet()){
            event.register((stack, index) -> entry.getKey().getKey2().getColor(index), entry.getValue().get());
        }
    }
    @SubscribeEvent
    public void registerBlockColors(RegisterColorHandlersEvent.Block event){

        for(Map.Entry<StoneType, RegistryObject<Block>> entry : BlockRegistry.STONE_BLOCK.entrySet()){
            event.register((state, tintGetter, blockPos, index) ->
                    entry.getKey().getColor(index), entry.getValue().get());
        }
        for(Map.Entry<KeyPair<OreTypes, StoneType>, RegistryObject<OresBlock>> entry : BlockRegistry.ORE_BLOCKS.entrySet()){
            event.register((state, tintGetter, blockPos, index) ->
                    entry.getKey().getKey2().getColor(index), entry.getValue().get());
        }
    }
}
