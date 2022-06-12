package com.gildedrose.update;

import com.gildedrose.Item;

import static com.gildedrose.update.QualityConfiguration.SELL_DAY;

public abstract class AbstractItemUpdater implements ItemUpdater {


    @Override
    public final void updateItem(Item item) {
        int step = getQualityStep(item);
        updateItemQuality(item, step);
        updateItemSellIn(item);
    }

     protected abstract void updateItemQuality(Item item, int step);

    protected void updateItemSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected int getQualityStep(Item item) {
        int qualityStep = 1;
        if (sellDateIsPassed(item)) {
            qualityStep = 2;
        }
        return qualityStep;
    }

    private boolean sellDateIsPassed(Item item) {
        return item.sellIn <= SELL_DAY;
    }

}
