package org.labrat.torrentofwar.proxy;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.labrat.torrentofwar.registry.BlockRegistry;
import org.labrat.torrentofwar.registry.ItemRegistry;

public class CommonProxy {
    public CommonProxy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);

        ItemRegistry.init(modEventBus);
        BlockRegistry.init(modEventBus);
    }
}
