package org.labrat.torrentofwar.datagen.custom;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.lang.Lang;
import java.util.HashMap;
import java.util.Map;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output) {
        super(output, TorrentOfWarMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for(Map.Entry<String,String> entry : Lang.MAP.entrySet()){
            add(entry.getKey(),entry.getValue());
        }

    }
}
