package com.gildedrose.quality;

import com.gildedrose.Item;

public class NoopItemQualityUpdater implements UpdateQualityFunction {

    @Override
    public void updateItemQuality(Item item) {
        //noop as a noop should
    }
}
