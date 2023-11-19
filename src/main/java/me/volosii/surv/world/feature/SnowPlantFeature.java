package me.volosii.surv.world.feature;

import net.minecraft.block.Block;
import net.minecraft.block.PlantBlock;
import net.minecraft.class_239;
import net.minecraft.world.World;

import java.util.Random;

public class SnowPlantFeature extends class_239 {
    private int blockId;

    public SnowPlantFeature(int blockId) {
        this.blockId = blockId;
    }

    @Override
    public boolean method_1142(World world, Random random, int x, int y, int z) {
        for(int var6 = 0; var6 < 64; ++var6) {
            int x2 = x + random.nextInt(8) - random.nextInt(8);
            int y2 = y + random.nextInt(4) - random.nextInt(4);
            int z2 = z + random.nextInt(8) - random.nextInt(8);
            if ((world.method_234(x2, y2, z2) || world.getBlockId(x2, y2, z2) == Block.SNOW.id) && Block.BLOCKS[this.blockId].canGrow(world, x2, y2, z2)) {
                world.method_200(x2, y2, z2, this.blockId);
            }
        }

        return true;
    }
}
