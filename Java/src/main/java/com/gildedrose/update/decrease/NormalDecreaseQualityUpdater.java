package com.gildedrose.update.decrease;

import com.gildedrose.Item;
import com.gildedrose.update.AbstractItemUpdater;

public class NormalDecreaseQualityUpdater extends AbstractItemUpdater {

    @Override
    protected void updateItemQuality(Item item) {

        // possible bug, line below added to keep current behaviour
        if (item.quality < MIN_QUALITY) return;

        int qualityStep = getQualityStep(item);
        item.quality = Math.max(MIN_QUALITY, item.quality -qualityStep);
    }
}
