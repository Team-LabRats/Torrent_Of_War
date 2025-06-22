package org.labrat.torrent_of_war;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.labrat.torrent_of_war.proxy.ClientProxy;
import org.labrat.torrent_of_war.proxy.CommonProxy;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TorrentOfWarMod.MODID)
public class TorrentOfWarMod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "torrent_of_war";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TorrentOfWarMod() {
        DistExecutor.unsafeRunForDist(()-> ClientProxy::new, ()-> CommonProxy::new);
    }

}
