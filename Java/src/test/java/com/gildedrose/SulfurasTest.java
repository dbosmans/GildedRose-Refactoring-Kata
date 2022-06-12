package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.update.QualityConfiguration.SULFURAS;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
According to specs sulfuras should always return 80 ?
 */
public class SulfurasTest extends GildedRoseSetup {

    @Test
    void haveFixedValues() {
        Item item = createItem(SULFURAS, 5, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(5, item.sellIn);
        assertEquals(5, item.quality);
    }

    @Test
    void haveFixedValues_negativeSellIn() {
        Item item = createItem(SULFURAS, -10, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(-10, item.sellIn);
        assertEquals(5, item.quality);
    }

    @Test
    void haveFixedValues_negativeQuality() {
        Item item = createItem(SULFURAS, -10, -5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(-10, item.sellIn);
        assertEquals(-5, item.quality);
    }




}
