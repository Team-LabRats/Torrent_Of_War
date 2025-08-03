package org.labrat.torrentofwar.datagen.custom;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.labrat.torrentofwar.TorrentOfWarMod;
import org.labrat.torrentofwar.api.block.OresBlock;
import org.labrat.torrentofwar.api.ores.OreTypes;
import org.labrat.torrentofwar.api.ores.StoneModelType;
import org.labrat.torrentofwar.api.ores.StoneType;
import org.labrat.torrentofwar.registry.BlockRegistry;
import org.labrat.torrentofwar.utils.KeyPair;

import java.util.Map;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TorrentOfWarMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(Map.Entry<KeyPair<OreTypes, StoneType>, RegistryObject<OresBlock>> entry : BlockRegistry.ORE_BLOCKS.entrySet()){
            blockOre(entry.getValue().get(),
                   entry.getKey().getKey2());
        }

        for(Map.Entry<StoneType, RegistryObject<Block>> entry : BlockRegistry.STONE_BLOCK.entrySet()){
            blockStone(entry.getValue().get(), entry.getKey().getTextureType());
        }

    }

    private void blockStone(@NotNull Block block, StoneModelType key) {
        simpleBlockWithItem(block,textureStone(block,key));
    }

    private ModelFile textureStone(@NotNull Block block, StoneModelType key) {
        return models().withExistingParent(name(block), ResourceLocation.parse(key.getId()));

    }

    public BlockModelBuilder texturesTwoLocation(String name, ResourceLocation parent,
                                           String textureKey1, ResourceLocation texture1,
                                                 String textureKey2, ResourceLocation texture2) {
        return models().withExistingParent(name, parent).texture(textureKey1, texture1).texture(textureKey2, texture2);
    }

    private ModelFile texturesCustomOres(OresBlock block, StoneType types) {
        return texturesTwoLocation(name(block),stringBlockParent(block,"ore"),
                "0", ResourceLocation.parse(types.getTextureType().getId()),
                "1", block.getOreType().getResourceLocation());
    }
    public BlockModelBuilder texturesOres(OresBlock block, StoneType types){
        return texturesTwoLocation(name(block),stringBlockParent(block,"ore"),
                "0", ResourceLocation.fromNamespaceAndPath(types.getModid(),"block/"+ types.getBlockId()),
                "1", block.getOreType().getResourceLocation());
    }

    private void blockOre(OresBlock block, StoneType types){
        if(types.getBlock() == null){
            simpleBlockWithItem(block,texturesCustomOres(block,types));
            return;
        }
        simpleBlockWithItem(block,texturesOres(block,types));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }

    public ResourceLocation stringBlockParent(Block block,String path) {
        ResourceLocation name = key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModelProvider.BLOCK_FOLDER + "/" + path);
    }
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

}
