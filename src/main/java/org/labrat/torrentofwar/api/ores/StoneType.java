package org.labrat.torrentofwar.api.ores;

import lombok.Getter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.labrat.torrentofwar.TorrentOfWarMod;

public enum StoneType {
    STONE(Blocks.STONE),
    DEEPSLATE(Blocks.DEEPSLATE),
    NETHERRACK(Blocks.NETHERRACK),
    END_STONE(Blocks.END_STONE),

    SOAP_STONE(TorrentOfWarMod.MODID, StoneModelType.HORIZONTAL,0x333333,
            2.0F, 6.0F)
    ;

    @Getter
    Block block;

    StoneType(Block block) {
        this.block = block;
    }

    @Getter
    String modid;

    @Getter
    StoneModelType textureType;
    @Getter
    float hardness;
    @Getter
    int primaryColour;
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
        return primaryColour;
    }
}
