package org.labrat.torrentofwar.api.ores;

import lombok.Getter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.api.Utils;

import java.util.Objects;

public enum StoneType {
    STONE(Blocks.STONE, "stone"),
    DEEPSLATE(Blocks.DEEPSLATE, "deepslate"),
    NETHERRACK(Blocks.NETHERRACK, "netherrack"),
    ENDSTONE(Blocks.END_STONE, "end_stone"),

    SOAPSTONE(TorrentOfWarMod.MODID, StoneModelType.HORIZONTAL,0x333333,
            2.0F, 6.0F)
    ;

    @Getter
    Block block;

    @Getter
    String modid;
    StoneType(Block block) {
        this.block = block;
        this.modid = ForgeRegistries.BLOCKS.getKey(block).getNamespace();
    }
    @Getter
    String blockId;
    StoneType(Block block, String blockId) {
        this(block);
        this.blockId = blockId;
    }


    @Getter
    StoneModelType textureType;
    @Getter
    float hardness;
    @Getter
    int primaryColour = Utils.INT_NULL;
    @Getter
    float resistance;

    StoneType(String modid, StoneModelType textureType, int primaryColour, float hardness, float resistance) {
        this.modid = modid;
        this.textureType = textureType;
        this.primaryColour = primaryColour;
        this.hardness = hardness;
        this.resistance = resistance;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    public int getColor(int index) {
        if(index == 0 && !Utils.isNull(primaryColour))
            return primaryColour;
        return -1;
    }

    public boolean isVanilla() {
        return Utils.isNull(primaryColour);
    }
}
