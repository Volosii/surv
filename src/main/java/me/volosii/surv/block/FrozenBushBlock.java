package me.volosii.surv.block;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplatePlantBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FrozenBushBlock extends TemplatePlantBlock {

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return 0;
    }

    @Override
    public boolean canGrow(World world, int x, int y, int z) {
        return (world.method_252(x, y, z) >= 8 || world.method_249(x, y, z) || world.getBlockId(x, y, z) == Block.SNOW.id) && method_1683(world.getBlockId(x, y - 1, z));
    }

    public FrozenBushBlock(Identifier identifier, int texture) {
        super(identifier, texture);
    }
}
