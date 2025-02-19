package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.update.QualityConfiguration.AGED_BRIE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest extends GildedRoseSetup {

    @Test
    void agedBrieIncreasesQualityBeforeSelByDate() {
        Item item = createItem(AGED_BRIE, 5, 4);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(5, item.quality);
    }

    /*
    specs don't mention increase should also be doubled after sell by date,
    but assuming current implementation is correct, quality => 42 ?
     */
    @Test
    void increasesQualityAfterSelByDate() {
        Item item = createItem(AGED_BRIE, -5, 40);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(-6, item.sellIn);
        assertEquals(42, item.quality);
    }

    @Test
    void maxQuality50() {
        Item item = createItem(AGED_BRIE, 5, 49);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
        app.updateQuality();
        assertEquals(3, item.sellIn);
        assertEquals(50, item.quality);
    }

    /*
        according to specs, max quality should be 50
    */
    @Test
    void maxQuality50IllegalInput() {
        Item item = createItem(AGED_BRIE, 5, 100);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(100, item.quality);
    }


}
