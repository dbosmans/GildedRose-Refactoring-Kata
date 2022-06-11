package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
According to specs sulfuras should always return 80 ?
 */
public class SulfurasTest extends GildedRoseSetup {

    @Test
    void haveFixedValues() {
        Item item = new Item(SULFURAS, 5, 5);
        GildedRose app = new GildedRose(items(item));
        app.updateQuality();
        assertEquals(5, item.sellIn);
        assertEquals(5, item.quality);
    }

    @Test
    void haveFixedValues_negativeSellIn() {
        Item item = new Item(SULFURAS, -10, 5);
        GildedRose app = new GildedRose(items(item));
        app.updateQuality();
        assertEquals(-10, item.sellIn);
        assertEquals(5, item.quality);
    }

    @Test
    void haveFixedValues_negativeQuality() {
        Item item = new Item(SULFURAS, -10, -5);
        GildedRose app = new GildedRose(items(item));
        app.updateQuality();
        assertEquals(-10, item.sellIn);
        assertEquals(-5, item.quality);
    }




}
