package com.gildedrose.quality.increase;

import com.gildedrose.Item;

public class BackStagePassesQualityUpdater extends IncreaseQualityUpdater {

    @Override
     public int getQualityStep(Item item) {
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
