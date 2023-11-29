package me.volosii.surv.block1;

import me.volosii.surv.Surv;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.item.CustomItemOverlay;
import net.modificationstation.stationapi.api.template.block.TemplatePlantBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;


public class CottonGreenBlock extends TemplatePlantBlock {

    public int getDroppedItemId(int blockMeta, Random random) {
        return Surv.seedsCotton.id;
    }

    public CottonGreenBlock(Identifier identifier, int texture) {
        super(identifier, texture);
    }

}