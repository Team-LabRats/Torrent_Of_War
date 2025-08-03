package org.labrat.torrentofwar.api;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.labrat.torrentofwar.api.ores.OreTypes;
import org.labrat.torrentofwar.api.ores.StoneType;

public class Utils {
    public static final int INT_NULL = -500;

    public static boolean isNull(int INTEGER) {
        return INTEGER == INT_NULL;
    }

    public static Block getBlock(StoneType stoneType, OreTypes oreTypes){
        ResourceLocation identifier = FormattingUtils.toBlockIdName(stoneType,oreTypes);
        if(!ForgeRegistries.BLOCKS.containsKey(identifier))
            throw new IllegalStateException("[utils] Block with id %s doesnt exist".formatted(identifier));
        return ForgeRegistries.BLOCKS.getValue(identifier);
    }
}
