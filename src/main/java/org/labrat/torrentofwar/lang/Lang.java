package org.labrat.torrentofwar.lang;

import com.google.common.collect.HashBiMap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.labrat.torrentofwar.TorrentOfWarMod;

import java.util.HashMap;

public class Lang {
    public static HashMap<String, String> MAP = new HashMap<>();

    public static Component add(String key, String value){
        TorrentOfWarMod.LOGGER.info(key);
        if(MAP.containsKey(key))
            throw new IllegalStateException("CANT ADD LANG VALUE!!!");
        MAP.put(key,value);
        return Component.translatable(key);
    }
    public static <T extends Block> Component add(RegistryObject<T> block, String value){
        return add("block."+block.getId().toLanguageKey(),value);
    }
}
