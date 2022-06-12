package com.gildedrose.update;

import com.gildedrose.Item;
import com.gildedrose.update.decrease.DecreaseQualityUpdater;
import com.gildedrose.update.increase.AgedBrieUpdater;
import com.gildedrose.update.increase.BackStagePassesUpdater;

public enum ItemUpdaterFactory {

    INSTANCE;

    public ItemUpdater getItemUpdater(Item item) {

        if(isLegendary(item)) {
            return  new LegendaryItemUpdater();
        }
        if (isConjuredItem(item)) {
            return new ConjuredItemUpdater(getItemUpdaterForConjuredItem(item));
        }
       return getUpdater(item);
    }

    private ItemUpdater getUpdater(Item item) {
        if (isAgedBrie(item)) {
           return  new AgedBrieUpdater();
        }
        if (isBackStagePass(item)) {
           return  new BackStagePassesUpdater();
        }
        return new DecreaseQualityUpdater();
    }

    private AbstractItemUpdater getItemUpdaterForConjuredItem(Item item) {
        String conjuredItemName = item.name.substring(QualityConfiguration.CONJURED.length());
        Item originalItem = new Item(conjuredItemName, item.sellIn, item.quality);
        return (AbstractItemUpdater) getItemUpdater(originalItem);
    }

    private boolean isConjuredItem(Item item) {
        return (item.name.startsWith(QualityConfiguration.CONJURED));
    }

    private boolean isLegendary(Item item) {
        return QualityConfiguration.SULFURAS.equals(item.name);
    }
    private boolean isAgedBrie(Item item) {
        return QualityConfiguration.AGED_BRIE.equals(item.name);
    }

    private boolean isBackStagePass(Item item) {
        return QualityConfiguration.BACK_STAGE_PASSES.equals(item.name);
    }
}
