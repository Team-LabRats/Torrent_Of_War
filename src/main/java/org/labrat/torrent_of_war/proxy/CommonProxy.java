package org.labrat.torrent_of_war.proxy;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.labrat.torrent_of_war.registry.BlockRegistry;
import org.labrat.torrent_of_war.registry.ItemRegistry;

public class CommonProxy {
    public CommonProxy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);

        ItemRegistry.init(modEventBus);
        BlockRegistry.init(modEventBus);
    }
}
