package com.gildedrose.update.increase;

import com.gildedrose.Item;
import com.gildedrose.update.AbstractItemUpdater;

public class IncreaseQualityUpdater extends AbstractItemUpdater {

     protected void updateItemQuality(Item item) {

        // possible bug, line below added to keep current behaviour
        if (item.quality > MAX_QUALITY) return;

        int qualityStep = getQualityStep(item);
        item.quality = Math.min(MAX_QUALITY, item.quality + qualityStep);
    }
}
