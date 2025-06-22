package org.labrat.torrent_of_war.proxy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import org.labrat.torrent_of_war.TorrentOfWarMod;

@Mod.EventBusSubscriber(modid = TorrentOfWarMod.MODID,value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientProxy extends CommonProxy{
}
