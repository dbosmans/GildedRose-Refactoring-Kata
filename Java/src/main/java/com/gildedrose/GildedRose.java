package com.gildedrose;

import com.gildedrose.quality.*;
import com.gildedrose.quality.decrease.DecreaseQualityUpdater;
import com.gildedrose.quality.increase.BackStagePassesQualityUpdater;
import com.gildedrose.quality.increase.IncreaseQualityUpdater;

import java.util.Arrays;
import java.util.Objects;

class GildedRose {

    static final String AGED_BRIE = "Aged Brie";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String BACK_STAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String CONJURED = "Conjured";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /*
    Maybe make stream parallel (expected array size ?)
     */
    public void updateQuality() {
        Arrays.stream(items)
            .filter(Objects::nonNull)
            .forEach(this::updateItem);
    }

    private void updateItem(Item item) {
        getUpdateFunction(item.name).updateItemQuality(item);
        updateItemSellIn(item);
    }

    private UpdateQualityFunction getUpdateFunction(String name) {
        switch (name) {
            case SULFURAS: return new NoopItemQualityUpdater();
            case AGED_BRIE: return new IncreaseQualityUpdater();
            case BACK_STAGE_PASSES: return new BackStagePassesQualityUpdater();
            default: return new DecreaseQualityUpdater();
        }
    }

    private void updateItemSellIn(Item item) {
        if (shouldUpdateSellIn(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private boolean shouldUpdateSellIn(Item item) {
        return !SULFURAS.equals(item.name);
    }

}
