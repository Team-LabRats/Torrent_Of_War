package org.labrat.torrent_of_war.api.block;

import lombok.Getter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.labrat.torrent_of_war.api.ores.OreTypes;
import org.labrat.torrent_of_war.api.ores.StoneType;

import java.util.ArrayList;
import java.util.List;

public class OresBlock extends Block {
    @Getter
    public OreTypes oreType;

    @Getter
    public StoneType stoneType;

    public OresBlock(OreTypes oreType, StoneType stoneTypes) {
        super(BlockBehaviour.Properties.of());
        this.oreType = oreType;
        this.stoneType = (stoneTypes);
    }
}
