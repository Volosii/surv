package me.volosii.surv;

import me.volosii.surv.block.FlowerShootBlock;
import me.volosii.surv.block.FrozenBushBlock;
import me.volosii.surv.world.feature.SnowPlantFeature;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.class_231;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.template.block.*;
import net.modificationstation.stationapi.api.util.Namespace;
import org.checkerframework.checker.units.qual.A;

public class Surv {
    @Entrypoint.Namespace
    Namespace namespace;

    Block woodGlass;
    Block megaWoodGlass;
    Block whiteFlower;
    Block saltBlock;
    Block purpleFlower;
    Block frozenBush;
    Block whiteFlowerShoot;
    Block purpleFlowerShoot;

    @EventListener
    void registerBlock(BlockRegistryEvent event) {
        saltBlock = new TemplateBlock(namespace.id("salt_block"), 0, Material.STONE).setHardness(0.4f);
        woodGlass = new TemplateGlassBlock(namespace.id("wood_glass"), 0, Material.SAND, false).setHardness(0.4f);
        megaWoodGlass = new TemplateGlassBlock(namespace.id("mega_wood_glass"), 0, Material.SAND, false).setHardness(0.4f);
        whiteFlower = new TemplatePlantBlock(namespace.id("white_flower"), 0);
        whiteFlowerShoot = new FlowerShootBlock(namespace.id("white_flower_shoot"), whiteFlower);
        purpleFlower = new TemplatePlantBlock(namespace.id("purple_flower"), 0);
        purpleFlowerShoot = new FlowerShootBlock(namespace.id("purple_flower_shoot"), purpleFlower);
        frozenBush = new FrozenBushBlock(namespace.id("frozen_bush"), 0);
    }



    @EventListener
    void generateFlower(WorldGenEvent.ChunkDecoration event) {
        for (int i = 0; i < 3; i++) {
            int x = event.x + event.random.nextInt(16) + 8;
            int y = event.random.nextInt(event.world.getHeight()) + event.world.getBottomY();
            int z = event.z + event.random.nextInt(16) + 8;
            new class_231(whiteFlower.id).method_1142(event.world, event.random, x, y, z);
        }
        for (int i = 0; i < 3; i++) {
            int x = event.x + event.random.nextInt(16) + 8;
            int y = event.random.nextInt(event.world.getHeight()) + event.world.getBottomY();
            int z = event.z + event.random.nextInt(16) + 8;
            new class_231(purpleFlower.id).method_1142(event.world, event.random, x, y, z);
        }
        if (event.world.dimension.field_2174.method_1787(event.x, event.z).method_793()) {
            for (int i = 0; i < 3; i++) {
                int x = event.x + event.random.nextInt(16) + 8;
                int y = event.random.nextInt(event.world.getHeight()) + event.world.getBottomY();
                int z = event.z + event.random.nextInt(16) + 8;
                new SnowPlantFeature(frozenBush.id).method_1142(event.world, event.random, x, y, z);
            }
        }
    }

    @EventListener
    void registerTexture(TextureRegisterEvent event) {
        saltBlock.textureId = Atlases.getTerrain().addTexture(namespace.id("block/saltblock")).index;
        woodGlass.textureId = Atlases.getTerrain().addTexture(namespace.id("block/woodglass")).index;
        megaWoodGlass.textureId = Atlases.getTerrain().addTexture(namespace.id("block/megawoodglass")).index;
        whiteFlower.textureId = Atlases.getTerrain().addTexture(namespace.id("block/whiteflower")).index;
        whiteFlower.asItem().method_458(whiteFlower.textureId);
        purpleFlower.textureId = Atlases.getTerrain().addTexture(namespace.id("block/purpleflower")).index;
        purpleFlower.asItem().method_458(purpleFlower.textureId);
        frozenBush.textureId = Atlases.getTerrain().addTexture(namespace.id("block/frozenbush")).index;
        purpleFlowerShoot.textureId = whiteFlowerShoot.textureId = Atlases.getTerrain().addTexture(namespace.id("block/flowershoot")).index;
        int flowerSeedTexture = Atlases.getTerrain().addTexture(namespace.id("block/flowerseed")).index;
        whiteFlowerShoot.asItem().method_458(flowerSeedTexture);
        purpleFlowerShoot.asItem().method_458(flowerSeedTexture);
        frozenBush.asItem().method_458(frozenBush.textureId);

    }

    @EventListener
    void registerRecipe(RecipeRegisterEvent event) {
        if (event.recipeId == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemStack(woodGlass, 1), Block.GLASS);
            CraftingRegistry.addShapelessRecipe(new ItemStack(megaWoodGlass, 1), Block.DIRT);
            CraftingRegistry.addShapelessRecipe(new ItemStack(whiteFlowerShoot), whiteFlower);
            CraftingRegistry.addShapelessRecipe(new ItemStack(purpleFlowerShoot), purpleFlower);
        }
    }
}

