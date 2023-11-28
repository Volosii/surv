package me.volosii.surv.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.template.block.TemplatePlantBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class RyeCustomBlock extends TemplatePlantBlock {
    public int getDroppedItemCount(Random random) {
        return random.nextInt(5) == 0 ? 1 : 0;
    }

    public int getDroppedItemId(int blockMeta, Random random) {
        return Item.SEEDS.id;
    }

    public RyeCustomBlock(Identifier identifier, int texture) {
        super(identifier, texture);
    }
}
