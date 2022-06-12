package com.gildedrose.update.increase;

import com.gildedrose.Item;
import com.gildedrose.update.AbstractItemUpdater;
import com.gildedrose.update.QualityConfiguration;

public class IncreaseQualityUpdater extends AbstractItemUpdater {

     public void updateItemQuality(Item item, int qualityStep) {

        // possible bug, line below added to keep current behaviour
        if (item.quality > QualityConfiguration.MAX_QUALITY) return;

        item.quality = Math.min(QualityConfiguration.MAX_QUALITY, item.quality + qualityStep);
    }
}
