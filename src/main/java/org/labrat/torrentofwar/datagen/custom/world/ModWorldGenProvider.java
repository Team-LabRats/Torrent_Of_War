package org.labrat.torrentofwar.datagen.custom.world;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.server.world.WorldGenerationManager;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, WorldGenerationManager::bootstrapConfiguredFeature)
            .add(Registries.PLACED_FEATURE, WorldGenerationManager::bootstrapPlacedFeatures)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, WorldGenerationManager::bootstrapBiomeModifiers);
    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(TorrentOfWarMod.MODID));
    }
}
