package me.volosii.surv.block1;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplatePlantBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FlowerShootBlock extends TemplatePlantBlock {
    Block flower;

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        super.onTick(world, x, y, z, random);
        if (random.nextInt(10) == 0){
            world.setBlock(x,y,z,flower.id);
        }
    }

    public FlowerShootBlock(Identifier identifier, Block flower) {
        super(identifier, 0);
        this.flower = flower;
        setTickRandomly(true);
    }
}