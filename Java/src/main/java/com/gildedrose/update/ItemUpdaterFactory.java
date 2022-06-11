package com.gildedrose.update;

import com.gildedrose.Item;
import com.gildedrose.update.decrease.ConjuredItemUpdater;
import com.gildedrose.update.decrease.NormalDecreaseQualityUpdater;
import com.gildedrose.update.increase.AgedBrieUpdater;
import com.gildedrose.update.increase.BackStagePassesUpdater;
import com.gildedrose.update.increase.IncreaseQualityUpdater;

public enum ItemUpdaterFactory {

    INSTANCE;

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACK_STAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured";

    public AbstractItemUpdater getItemUpdater(Item item) {

        if(shouldNotUpdate(item)) {
            return new NoopItemUpdater();
        }
        if (isAgedBrie(item)) {
            return new AgedBrieUpdater();
        }
        if (isBackStagePass(item)) {
            return new BackStagePassesUpdater();
        }
        if (isConjuredItem(item)) {
            return new ConjuredItemUpdater();
        }

        return new NormalDecreaseQualityUpdater();

    }

    private boolean isConjuredItem(Item item) {
        return CONJURED.equals(item.name);
    }

    private boolean shouldNotUpdate(Item item) {
        return SULFURAS.equals(item.name);
    }
    private boolean isAgedBrie(Item item) {
        return AGED_BRIE.equals(item.name);
    }

    private boolean isBackStagePass(Item item) {
        return BACK_STAGE_PASSES.equals(item.name);
    }
}
