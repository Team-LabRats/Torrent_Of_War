package org.labrat.torrentofwar.server.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeModifier;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.api.FormattingUtils;
import org.labrat.torrentofwar.api.Utils;
import org.labrat.torrentofwar.api.keys.TriKeys;
import org.labrat.torrentofwar.api.ores.OreTypes;
import org.labrat.torrentofwar.api.ores.StoneType;
import org.labrat.torrentofwar.api.world.rules.RuleTestUtils;
import org.labrat.torrentofwar.api.keys.KeyPair;

import java.util.HashMap;
import java.util.List;

public class WorldGenerationManager {
    private static HashMap<KeyPair<StoneType, OreTypes>, ResourceKey<ConfiguredFeature<?,?>>> CONFIGURED_FEATURE_KEYS = new HashMap<>();
    private static HashMap<KeyPair<StoneType, OreTypes>, ConfiguredFeature<?,?>> CONFIGURED_FEATURES = new HashMap<>();
    private static HashMap<KeyPair<StoneType, OreTypes>, RuleTest> RULE_TEST = new HashMap<>();

    public static void init() {
        for(OreTypes oreType : OreTypes.values()){
            for(StoneType stoneType : StoneType.values()){
                initConfiguredFeatureKeys(oreType,stoneType);
                initConfiguredFeatures(oreType,stoneType);
                initPlacedFeatures(oreType,stoneType);
            }
        }
    }

    private static void initConfiguredFeatureKeys(OreTypes oreType, StoneType stoneType) {
        CONFIGURED_FEATURE_KEYS.put(new KeyPair<>(stoneType,oreType),
                registerConfiguredFeatureKey(FormattingUtils.toBlockId(stoneType,oreType)));
    }

    private static void initConfiguredFeatures(OreTypes oreType, StoneType stoneType) {
        RuleTest ruleTest = RuleTestUtils.getRuleTest(Utils.getBlock(stoneType,oreType));

        RULE_TEST.put(new KeyPair<>(stoneType,oreType), ruleTest);

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeatureKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TorrentOfWarMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>>
    void registerConfiguredFeatures(BootstapContext<ConfiguredFeature<?, ?>> context,
        ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    private static void initPlacedFeatures(OreTypes oreType, StoneType stoneType) {

    }


    public static void bootstrapConfiguredFeature(BootstapContext<ConfiguredFeature<?,?>> context) {
        for(OreTypes oreType : OreTypes.values()){
            for(StoneType stoneType : StoneType.values()){
                registerConfiguredFeatures(context,CONFIGURED_FEATURE_KEYS.get(new KeyPair<>(stoneType,oreType)),Feature.ORE,
                        new OreConfiguration(RULE_TEST.get(new KeyPair<>(stoneType,oreType)), oreType.));
            }
        }
    }

    public static void bootstrapPlacedFeatures(BootstapContext<PlacedFeature> context) {
    }

    public static void bootstrapBiomeModifiers(BootstapContext<BiomeModifier> context) {
    }
}
