package me.volosii.surv;

import me.volosii.surv.block1.CottonGreenBlock;
import me.volosii.surv.block1.FlowerShootBlock;
import me.volosii.surv.block1.FrozenBushBlock;
import me.volosii.surv.block1.RyeCustomBlock;
import me.volosii.surv.world.feature.SnowPlantFeature;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.*;
import net.minecraft.class_231;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.DoorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.event.registry.BlockItemRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.EntityHandlerRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.template.block.*;
import net.modificationstation.stationapi.api.template.item.TemplateDoorItem;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.template.item.TemplateSeedsItem;
import net.modificationstation.stationapi.api.util.Namespace;


public class Surv {
    @Entrypoint.Namespace
    Namespace namespace;
    Block greenWheat;
    Block cottonGreenBig;
    Block woodGlass;
    Block megaWoodGlass;
    Block whiteFlower;
    Block saltBlock;
    Block purpleFlower;
    Block frozenBush;
    Block whiteFlowerShoot;
    Block purpleFlowerShoot;

    public static Item seedsCotton;

    @EventListener
    void registerItem(ItemRegistryEvent event) {
        seedsCotton = new TemplateSeedsItem(namespace.id("cotton_seeds"), 0);
    }



    @EventListener
    void registerBlock(BlockRegistryEvent event) {
        cottonGreenBig = new CottonGreenBlock(namespace.id("cotton_green_big"), 0);
        greenWheat = new RyeCustomBlock(namespace.id("green_wheat"),0);
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
            new class_231(greenWheat.id).method_1142(event.world, event.random, x, y, z);

        }
        for (int i = 0; i < 3; i++) {
            int x = event.x + event.random.nextInt(16) + 8;
            int y = event.random.nextInt(event.world.getHeight()) + event.world.getBottomY();
            int z = event.z + event.random.nextInt(16) + 8;
            new class_231(cottonGreenBig.id).method_1142(event.world, event.random, x, y, z);
        }

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
        cottonGreenBig.textureId = Atlases.getTerrain().addTexture(namespace.id("block/cottonplantgreenbig")).index;
        greenWheat.textureId = Atlases.getTerrain().addTexture(namespace.id("block/greenwheat")).index;
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
        seedsCotton.method_458(Atlases.getGuiItems().addTexture(namespace.id("block/flowerseed")).index);
        frozenBush.asItem().method_458(frozenBush.textureId);

    }



    @EventListener
    void registerRecipe(RecipeRegisterEvent event) {
        if (event.recipeId == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemStack(whiteFlowerShoot, 2), whiteFlower);
            CraftingRegistry.addShapelessRecipe(new ItemStack(purpleFlowerShoot, 2), purpleFlower);


        }
    }
}

