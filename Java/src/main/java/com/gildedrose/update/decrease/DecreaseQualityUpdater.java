package com.gildedrose.update.decrease;

import com.gildedrose.Item;
import com.gildedrose.update.AbstractItemUpdater;
import com.gildedrose.update.QualityConfiguration;

public class DecreaseQualityUpdater extends AbstractItemUpdater {

    @Override
    public void updateItemQuality(Item item, int qualityStep) {

        // possible bug, line below added to keep current behaviour
        if (item.quality < QualityConfiguration.MIN_QUALITY) return;

        item.quality = Math.max(QualityConfiguration.MIN_QUALITY, item.quality - qualityStep);
    }
}
