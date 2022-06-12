package com.gildedrose.update.increase;

import com.gildedrose.Item;

import static com.gildedrose.update.QualityConfiguration.*;

public class BackStagePassesUpdater extends IncreaseQualityUpdater {
    // as per requirements borders should be 11 and 6
    @Override
     protected int getQualityStep(Item item) {
        int qualityStep = 1;
        if (closeToConcertDate(item)) {
            qualityStep = 2;
        }
        if (reallyCloseToConcertDate(item)) {
            qualityStep = 3;
        }
        if (concertIsPassed(item)) {
            qualityStep = - item.quality;
        }
        return qualityStep;
    }

    private boolean closeToConcertDate(Item item) {
        return item.sellIn <= BACKSTAGE_PASSES_DOUBLE;
    }

    private boolean reallyCloseToConcertDate(Item item) {
        return item.sellIn <= BACKSTAGE_PASSES_TRIPLE;
    }

    private boolean concertIsPassed(Item item) {
        return item.sellIn <= SELL_DAY;
    }

}
