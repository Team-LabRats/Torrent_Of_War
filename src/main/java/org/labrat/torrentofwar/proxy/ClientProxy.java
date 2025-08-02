package org.labrat.torrentofwar.proxy;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import org.labrat.torrentofwar.api.ores.StoneType;
import org.labrat.torrentofwar.registry.BlockRegistry;

import java.util.Map;

public class ClientProxy extends CommonProxy{
    @SubscribeEvent
    public void registerItemColors(RegisterColorHandlersEvent.Item event){

        for(Map.Entry<StoneType, RegistryObject<Block>> entry : BlockRegistry.STONE_BLOCK.entrySet()){
            event.register((stack, index) -> entry.getKey().getColor(index), entry.getValue().get());
        }
    }
    @SubscribeEvent
    public void registerBlockColors(RegisterColorHandlersEvent.Block event){

        for(Map.Entry<StoneType, RegistryObject<Block>> entry : BlockRegistry.STONE_BLOCK.entrySet()){
            event.register((state, tintGetter, blockPos, index) ->
                    entry.getKey().getColor(index), entry.getValue().get());
        }
    }
}
