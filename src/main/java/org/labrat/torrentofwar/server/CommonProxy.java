package org.labrat.torrentofwar.server;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.labrat.torrentofwar.server.registry.BlockRegistry;
import org.labrat.torrentofwar.server.registry.CreativeModeTabRegistry;
import org.labrat.torrentofwar.server.registry.ItemRegistry;

public class CommonProxy {
    public CommonProxy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);

        ItemRegistry.init(modEventBus);
        CreativeModeTabRegistry.init(modEventBus);
        BlockRegistry.init(modEventBus);
    }
}
