package me.volosii.surv;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.class_231;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.block.TemplatePlantBlock;
import net.modificationstation.stationapi.api.util.Namespace;

public class Surv {
    @Entrypoint.Namespace
    Namespace namespace;
    Block whiteFlower;
    Block purpleFlower;
    @EventListener
    void registerBlock(BlockRegistryEvent event) {
        whiteFlower = new TemplatePlantBlock(namespace.id("white_flower"),0);
        purpleFlower = new TemplatePlantBlock(namespace.id("purple_flower"),0);
    }
    @EventListener
    void generateFlower(WorldGenEvent.ChunkDecoration event) {
        for (int i = 0; i < 3; i++) {
            int x = event.x + event.random.nextInt(16) + 8;
            int y = event.random.nextInt(event.world.getHeight()) + event.world.getBottomY();
            int z = event.z + event.random.nextInt(16) + 8;
            new class_231(whiteFlower.id).method_1142(event.world,event.random,x,y,z);
        }
        for (int i = 0; i < 3; i++) {
            int x = event.x + event.random.nextInt(16) + 8;
            int y = event.random.nextInt(event.world.getHeight()) + event.world.getBottomY();
            int z = event.z + event.random.nextInt(16) + 8;
            new class_231(purpleFlower.id).method_1142(event.world,event.random,x,y,z);
        }
    }
    @EventListener
    void registerTexture(TextureRegisterEvent event) {
        whiteFlower.textureId = Atlases.getTerrain().addTexture(namespace.id("block/whiteflower")).index;
        purpleFlower.textureId = Atlases.getTerrain().addTexture(namespace.id("block/purpleflower")).index;
    }
}
