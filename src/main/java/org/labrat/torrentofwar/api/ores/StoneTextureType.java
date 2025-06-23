package org.labrat.torrentofwar.api.ores;

import lombok.Getter;
import org.labrat.torrentofwar.TorrentOfWarMod;

public enum StoneTextureType {
    VERTICAL(TorrentOfWarMod.MODID+":block/stone/stone_vertical"),
    HORIZONTAL(TorrentOfWarMod.MODID+":block/stone/stone_horizontal");

    @Getter
    String id;

    StoneTextureType(String id) {
        this.id = id;
    }
}
