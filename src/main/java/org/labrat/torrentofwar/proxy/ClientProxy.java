package org.labrat.torrentofwar.proxy;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.api.block.OresBlock;
import org.labrat.torrentofwar.api.ores.StoneType;
import org.labrat.torrentofwar.registry.BlockRegistry;

import java.util.Map;

@Mod.EventBusSubscriber(modid = TorrentOfWarMod.MODID,value = Dist.CLIENT)
public class ClientProxy extends CommonProxy{

    @SubscribeEvent
    public void registerBlockColors(RegisterColorHandlersEvent.Block event){

        for(Map.Entry<StoneType, RegistryObject<Block>> entry : BlockRegistry.STONE_BLOCK.entrySet()){
            event.register(new BlockColor() {
                @Override
                public int getColor(BlockState state, @Nullable BlockAndTintGetter tintGetter,
                                    @Nullable BlockPos blockPos, int index) {
                    return entry.getKey().getColour();
                }
            }, entry.getValue().get());
        }

    }
}
