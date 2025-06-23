package org.labrat.torrentofwar.api.ores;

import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import org.labrat.torrentofwar.TorrentOfWarMod;

public enum OreTypes {
    TERRANIUM("terranium");

    @Getter
    String id;

    @Getter
    String modid = TorrentOfWarMod.MODID;

    OreTypes(String id) {
        this.id = id;
    }
    OreTypes(String modid,String id) {
        this.modid = modid;
        this.id = id;
    }

    public ResourceLocation getResourceLocation() {
        return ResourceLocation.fromNamespaceAndPath(modid,"block/ores/"+id);
    }
}
