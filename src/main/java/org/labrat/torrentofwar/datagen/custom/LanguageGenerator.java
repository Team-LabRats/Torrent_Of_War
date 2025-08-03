package org.labrat.torrentofwar.datagen.custom;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.client.lang.Lang;

import java.util.Map;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output) {
        super(output, TorrentOfWarMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for(Map.Entry<String,String> entry : Lang.MAP.entrySet()){
            String value = entry.getValue();
            if(entry.getValue().contains(" Stone "))
                value = value.replace(" Stone ", " ");
            add(entry.getKey(),value);
        }

    }
}
