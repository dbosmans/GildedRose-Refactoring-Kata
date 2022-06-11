package com.gildedrose;

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

    public void updateQuality() {
        Arrays.stream(items)
            .parallel()
            .filter(Objects::nonNull)
            .forEach(this::updateItem);
    }

    private void updateItem(Item item) {
        updateItemQuality(item);
        updateItemSellIn(item);
    }

    private void updateItemSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateItemQuality(Item item) {
        if (!item.name.equals(AGED_BRIE)
            && !item.name.equals(BACK_STAGE_PASSES)) {
            if (item.quality > 0) {
                if (!item.name.equals(SULFURAS)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACK_STAGE_PASSES)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (item.sellIn < 1) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACK_STAGE_PASSES)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(SULFURAS)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

    }
}
