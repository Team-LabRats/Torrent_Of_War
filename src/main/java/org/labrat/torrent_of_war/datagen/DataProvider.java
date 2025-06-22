package org.labrat.torrent_of_war.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.antlr.v4.codegen.model.chunk.TokenRef;
import org.labrat.torrent_of_war.TorrentOfWarMod;
import org.labrat.torrent_of_war.datagen.custom.BlockStateGenerator;

@Mod.EventBusSubscriber(modid = TorrentOfWarMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataProvider {

    @SubscribeEvent
    public static void registerDatagen(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new BlockStateGenerator(packOutput,existingFileHelper));
    }
}
