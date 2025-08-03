package org.labrat.torrentofwar.api;

import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.StringUtils;
import org.labrat.torrentofwar.api.ores.OreTypes;
import org.labrat.torrentofwar.api.ores.StoneType;
import org.labrat.torrentofwar.server.registry.BlockRegistry;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class FormattingUtils {

    /**
     * from <a href="https://github.com/GregTechCEu/GregTech-Modern/blob/1.20.1/src/main/java/com/gregtechceu/gtceu/utils/FormattingUtil.java">...</a>
     * apple_orange.juice => Apple Orange (Juice)
     */
    public static String toEnglishName(String internalName) {
        return Arrays.stream(internalName.toLowerCase(Locale.ROOT).split("_"))
                .map(StringUtils::capitalize)
                .collect(Collectors.joining(" "));
    }

    public static ResourceLocation toBlockIdName(StoneType stoneType, OreTypes oreType) {
        return ResourceLocation.fromNamespaceAndPath(stoneType.getModid(), toBlockId(stoneType, oreType));
    }
    public static String toBlockId(StoneType stoneType, OreTypes oreType) {
        return oreType.getId()+"_"+ stoneType.toString().toLowerCase() +"_ore";
    }
}
