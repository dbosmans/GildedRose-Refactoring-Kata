package com.gildedrose.update.decrease;

import com.gildedrose.Item;
import com.gildedrose.update.AbstractItemUpdater;

public class DecreaseQualityUpdater extends AbstractItemUpdater {

    @Override
    public void updateItemQuality(Item item, int qualityStep) {

        // possible bug, line below added to keep current behaviour
        if (item.quality < MIN_QUALITY) return;

        item.quality = Math.max(MIN_QUALITY, item.quality - qualityStep);
    }
}
