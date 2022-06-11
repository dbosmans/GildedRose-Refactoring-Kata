package com.gildedrose.update;

import com.gildedrose.Item;

public abstract class AbstractItemUpdater implements ItemUpdater {

    protected int MAX_QUALITY = 50;
    protected int MIN_QUALITY = 0;

    @Override
    public final void updateItem(Item item) {
        updateItemQuality(item);
        updateItemSellIn(item);
    }

    protected void updateItemSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected abstract void updateItemQuality(Item item);

    protected int getQualityStep(Item item) {
        int qualityStep = 1;
        if (item.sellIn <= 0) {
            qualityStep = 2;
        }
        return qualityStep;
    }

}
