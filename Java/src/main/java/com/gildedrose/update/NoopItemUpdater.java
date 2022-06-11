package com.gildedrose.update;

import com.gildedrose.Item;

public class NoopItemUpdater extends AbstractItemUpdater {

    @Override
    protected void updateItemQuality(Item item) {
        //noop as noop should
    }

    @Override
    protected void updateItemSellIn(Item item) {
        //noop as noop should
    }
}
