package org.labrat.torrentofwar.server.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.api.ores.StoneType;
import org.labrat.torrentofwar.client.lang.Lang;

public class CreativeModeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TorrentOfWarMod.MODID);

    public static final RegistryObject<CreativeModeTab> TORRENTOFWAR_TAB =
            REGISTER.register(TorrentOfWarMod.MODID+".tab", ()-> CreativeModeTab.builder()
                    .icon(()->new ItemStack(BlockRegistry.STONE_BLOCK.get(StoneType.SOAPSTONE).get().asItem()))
                    .title(Lang.add("itemGroup."+TorrentOfWarMod.MODID+".tab", "TorrentOfWar Tab"))
                    .displayItems((unused, output) -> {
                        BlockRegistry.STONE_BLOCK.forEach((stoneType, blockRegistryObject) -> {
                            output.accept(blockRegistryObject.get());
                        });
                        BlockRegistry.ORE_BLOCKS.forEach((stoneType,
                                                          blockRegistryObject) -> {
                            output.accept(blockRegistryObject.get());
                        });
                    })
                    .build());

    public static void init(IEventBus modEventBus){
        REGISTER.register(modEventBus);
    }
}
