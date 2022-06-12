package com.gildedrose.update.increase;

import com.gildedrose.Item;
import com.gildedrose.update.QualityConfiguration;

import static com.gildedrose.update.QualityConfiguration.*;

public class BackStagePassesUpdater extends IncreaseQualityUpdater {
    // as per requirements borders should be 11 and 6
    @Override
     protected int getQualityStep(Item item) {
        int qualityStep = 1;
        if (item.sellIn <= BACKSTAGE_PASSES_DOUBLE) {
            qualityStep = 2;
        }
        if (item.sellIn <= BACKSTAGE_PASSES_TRIPLE) {
            qualityStep = 3;
        }
        if (item.sellIn <= SELL_DAY) {
            qualityStep = - item.quality;
        }
        return qualityStep;
    }

}
