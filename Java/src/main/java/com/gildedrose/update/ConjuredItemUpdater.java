package com.gildedrose.update;

import com.gildedrose.Item;

import static com.gildedrose.update.QualityConfiguration.CONJURED_FACTOR;

public class ConjuredItemUpdater extends AbstractItemUpdater {

    private final AbstractItemUpdater itemUpdater;

    public ConjuredItemUpdater(AbstractItemUpdater itemUpdater) {
        this.itemUpdater = itemUpdater;
    }

    @Override
    protected void updateItemQuality(Item item, int qualityStep) {
        itemUpdater.updateItemQuality(item, qualityStep);
    }

    @Override
    protected void updateItemSellIn(Item item) {
        itemUpdater.updateItemSellIn(item);
    }

    @Override
    protected int getQualityStep(Item item) {
        return itemUpdater.getQualityStep(item) * CONJURED_FACTOR;
    }
}
