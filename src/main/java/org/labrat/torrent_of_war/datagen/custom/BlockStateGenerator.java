package org.labrat.torrent_of_war.datagen.custom;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.labrat.torrent_of_war.TorrentOfWarMod;
import org.labrat.torrent_of_war.api.block.OresBlock;
import org.labrat.torrent_of_war.api.ores.StoneType;
import org.labrat.torrent_of_war.registry.BlockRegistry;

import java.util.Map;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TorrentOfWarMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(Map.Entry<String, RegistryObject<OresBlock>> entry : BlockRegistry.ORE_BLOCKS.entrySet()){
            blockOre(entry.getValue().get(), entry.getValue().get().getStoneType());
        }

    }
    public BlockModelBuilder texturesTwoLocation(String name, ResourceLocation parent,
                                           String textureKey1, ResourceLocation texture1,
                                                 String textureKey2, ResourceLocation texture2) {
        return models().withExistingParent(name, parent).texture(textureKey1, texture1).texture(textureKey2, texture2);
    }

    public BlockModelBuilder texturesOres(OresBlock block, StoneType types){
        return texturesTwoLocation(name(block),stringBlockParent(block,"ore"),
                "0", ResourceLocation.parse(types.getBlock().getDescriptionId()),
                "1", block.getOreType().getResourceLocation());
    }
    private void blockOre(OresBlock block, StoneType types){
        simpleBlockWithItem(block,texturesOres(block,types));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }

    public ResourceLocation stringBlockParent(Block block,String path) {
        ResourceLocation name = key(block);
        return new ResourceLocation(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + path);
    }
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

}
