package com.gildedrose.update.decrease;

import com.gildedrose.Item;

public class ConjuredItemUpdater extends NormalDecreaseQualityUpdater {

    @Override
    public int getQualityStep(Item item) {
        return super.getQualityStep(item) * 2;
    }
}
