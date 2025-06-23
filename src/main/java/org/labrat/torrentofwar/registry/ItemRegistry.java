package org.labrat.torrentofwar.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.labrat.torrentofwar.TorrentOfWarMod;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TorrentOfWarMod.MODID);

    public static void init(IEventBus modEventBus){
        ITEMS.register(modEventBus);
    }
}
