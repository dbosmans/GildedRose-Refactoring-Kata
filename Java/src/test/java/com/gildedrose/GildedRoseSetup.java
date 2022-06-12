package com.gildedrose;

import com.gildedrose.update.QualityConfiguration;

public class GildedRoseSetup {


    Item createItem(String itemName, int beforeSellIn, int initialQuality) {
        return new Item(itemName, QualityConfiguration.SELL_DAY + beforeSellIn, initialQuality) ;
    }

    GildedRose createGildedRose(Item... items) {
        return new GildedRose(items);
    }

}
