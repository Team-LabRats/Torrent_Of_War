package org.labrat.torrentofwar.api.world.rules;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.HashMap;

public class RuleTestUtils {
    public static HashMap<Block, RuleTest> CACHE = new HashMap<>();
    public static <T extends Block> RuleTest getRuleTest(T block){
        return getRuleTest(block,true);
    }

    public static <T extends Block> RuleTest getRuleTest(T block, boolean useCache){
        if(useCache && CACHE.containsKey(block)){
            return CACHE.get(block);
        }
        RuleTest ruleTest = new BlockMatchTest(block);
        CACHE.put(block, ruleTest);
        return ruleTest;
    }
}
