package org.labrat.torrentofwar.api.block;

import lombok.Getter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.labrat.torrentofwar.api.ores.OreTypes;
import org.labrat.torrentofwar.api.ores.StoneType;

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
