package com.gildedrose.quality.decrease;

import com.gildedrose.Item;
import com.gildedrose.quality.UpdateQualityFunction;

public class DecreaseQualityUpdater implements UpdateQualityFunction {

    @Override
    public void updateItemQuality(Item item) {

        // possible bug, line below added to keep current behaviour
        if (item.quality < MIN_QUALITY) return;

        int qualityStep = getQualityStep(item);
        item.quality = Math.max(MIN_QUALITY, item.quality -qualityStep);
    }
}
