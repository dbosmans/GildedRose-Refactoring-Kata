package com.gildedrose;

import com.gildedrose.update.*;

import java.util.Arrays;
import java.util.Objects;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /*
    Maybe make stream parallel (expected array size ?)
     */
    public void updateQuality() {
        Arrays.stream(items)
            .filter(Objects::nonNull)
            .forEach(this::updateItem);
    }

    private void updateItem(Item item) {
        getUpdateFunction(item).updateItem(item);
    }

    private AbstractItemUpdater getUpdateFunction(Item item ) {
        return ItemUpdaterFactory.INSTANCE.getItemUpdater(item);
    }



}
