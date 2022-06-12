package com.gildedrose.update.increase;

import com.gildedrose.Item;

public class BackStagePassesUpdater extends IncreaseQualityUpdater {
    // as per requirements borders should be 11 and 6
    @Override
     protected int getQualityStep(Item item) {
        int qualityStep = 1;
        if (item.sellIn <= 10) {
            qualityStep = 2;
        }
        if (item.sellIn <= 5) {
            qualityStep = 3;
        }
        if (item.sellIn <= 0) {
            qualityStep = - item.quality;
        }
        return qualityStep;
    }

}
