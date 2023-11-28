package me.volosii.surv.block;

import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.client.item.CustomItemOverlay;
import net.modificationstation.stationapi.api.template.block.TemplatePlantBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;


public class CottonGreenBlock extends TemplatePlantBlock {
    public int getDroppedItemId(int blockMeta, Random random) {
        return 0;
    }

    public CottonGreenBlock(Identifier identifier, int texture) {
        super(identifier, texture);
    }

}