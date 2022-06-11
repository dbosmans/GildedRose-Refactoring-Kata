package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest extends GildedRoseSetup{

    @Test
    void foo() {
        Item item = new Item("foo", 0, 0) ;
        GildedRose app = new GildedRose(items(item));
        app.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }
    @Test
    void generalItem_onceSellInPassedQualityDegradesDouble() {
        Item item = new Item("foo", 0, 6);
        GildedRose app = new GildedRose(items(item));
        app.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(4, item.quality);
    }

    /*
    bug in current implementation ? missing validation
    assuming item creation validation is already handled, keeping current implementation
     */
    @Test
    void generalItem_maxQuality50() {
        Item item = new Item("foo", 5, 100);
        GildedRose app = new GildedRose(items(item));
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(99, item.quality); // should expect 50 ?
    }

     /*
    bug in current implementation ? missing validation
    assuming item creation validation is already handled, keeping current implementation
     */
    @Test
    void generalItem_minQualityInitallyNegative() {
        Item item = new Item("foo", 5, -10);
        GildedRose app = new GildedRose(items(item));
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(-10, item.quality);
    }

    @Test
    void generalItem_minQuality0() {
        Item item = new Item("foo", 5, 0);
        GildedRose app = new GildedRose(items(item));
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void generalItem_null() {
        GildedRose app = new GildedRose(new Item[1]);
        app.updateQuality();
    }








}
