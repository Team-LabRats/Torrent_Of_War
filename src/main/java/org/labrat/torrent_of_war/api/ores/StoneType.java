package org.labrat.torrent_of_war.api.ores;

import lombok.Getter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public enum StoneType {
    STONE(Blocks.STONE),
    DEEPSLATE(Blocks.DEEPSLATE),
    NETHERRACK(Blocks.NETHERRACK),
    END_STONE(Blocks.END_STONE)
    ;

    @Getter
    Block block;

    StoneType(Block block) {
        this.block = block;
    }
}
