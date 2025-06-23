package org.labrat.torrentofwar;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.labrat.torrentofwar.proxy.ClientProxy;
import org.labrat.torrentofwar.proxy.CommonProxy;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TorrentOfWarMod.MODID)
public class TorrentOfWarMod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "torrentofwar";
    public static final String NAME = "Torrent of War";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TorrentOfWarMod() {
        TorrentOfWarMod.init();
        DistExecutor.unsafeRunForDist(()-> ClientProxy::new, ()-> CommonProxy::new);
    }

    private static void init() {
        LOGGER.info("{} is initializing---", NAME);
    }

}
