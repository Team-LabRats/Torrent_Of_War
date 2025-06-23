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

    SOAP_STONE(TorrentOfWarMod.MODID,StoneTextureType.VERTICAL,0xfffbd9 ,
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
    StoneTextureType textureType;
    @Getter
    float hardness;
    @Getter
    int colour;
    @Getter
    float resistance;

    StoneType(String modid, StoneTextureType textureType, int colour, float hardness, float resistance) {
        this.modid = modid;
        this.textureType = textureType;
        this.colour = colour;
        this.hardness = hardness;
        this.resistance = resistance;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
