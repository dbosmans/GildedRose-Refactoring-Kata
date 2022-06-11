package com.gildedrose.quality.decrease;

import com.gildedrose.Item;
import com.gildedrose.quality.UpdateQualityFunction;

public class ConjuredQualityUpdater extends DecreaseQualityUpdater {

    @Override
    public int getQualityStep(Item item) {
        return super.getQualityStep(item) * 2;
    }
}
