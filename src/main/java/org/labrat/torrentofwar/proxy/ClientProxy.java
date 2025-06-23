package org.labrat.torrentofwar.proxy;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.api.block.OresBlock;
import org.labrat.torrentofwar.registry.BlockRegistry;

import java.util.Map;

@Mod.EventBusSubscriber(modid = TorrentOfWarMod.MODID,value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientProxy extends CommonProxy{

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
    }
}
