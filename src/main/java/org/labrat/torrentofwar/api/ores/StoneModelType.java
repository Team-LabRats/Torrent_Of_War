package org.labrat.torrentofwar.api.ores;

import lombok.Getter;
import org.labrat.torrentofwar.TorrentOfWarMod;

public enum StoneModelType {
    VERTICAL(TorrentOfWarMod.MODID+":block/stone/stone_vertical"),
    HORIZONTAL(TorrentOfWarMod.MODID+":block/stone/stone_horizontal");

    @Getter
    String id;

    StoneModelType(String id) {
        this.id = id;
    }
}
