package com.gildedrose.update;

import com.gildedrose.Item;
import com.gildedrose.update.decrease.DecreaseQualityUpdater;
import com.gildedrose.update.increase.AgedBrieUpdater;
import com.gildedrose.update.increase.BackStagePassesUpdater;

public enum ItemUpdaterFactory {

    INSTANCE;

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACK_STAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured ";

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
        String conjuredItemName = item.name.substring(CONJURED.length());
        Item originalItem = new Item(conjuredItemName, item.sellIn, item.quality);
        return (AbstractItemUpdater) getItemUpdater(originalItem);
    }

    private boolean isConjuredItem(Item item) {
        return (item.name.startsWith(CONJURED));
    }

    private boolean isLegendary(Item item) {
        return SULFURAS.equals(item.name);
    }
    private boolean isAgedBrie(Item item) {
        return AGED_BRIE.equals(item.name);
    }

    private boolean isBackStagePass(Item item) {
        return BACK_STAGE_PASSES.equals(item.name);
    }
}
