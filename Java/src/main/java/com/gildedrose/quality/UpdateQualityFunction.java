package com.gildedrose.quality;

import com.gildedrose.Item;

@FunctionalInterface
public interface UpdateQualityFunction {

    int MAX_QUALITY = 50;
    int MIN_QUALITY = 0;
    void updateItemQuality(Item item);

    default int getQualityStep(Item item) {
        int qualityStep = 1;
        if (item.sellIn <= 0) {
            qualityStep = 2;
        }
        return qualityStep;
    }
}
