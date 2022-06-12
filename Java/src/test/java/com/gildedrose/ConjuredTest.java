package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.update.QualityConfiguration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTest extends GildedRoseSetup {

    @Test
    void decreaseIsDoubled() {
        Item item = createItem(CONJURED, 5, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(3, item.quality);
    }

    @Test
    void decreaseIsDoubleDoubled_afterSellByDate() {
        Item item = createItem(CONJURED, 0, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(1, item.quality);
    }


    @Test
    void conjuredAgedBrieAfterSellDate() {
        Item item = createItem(CONJURED + AGED_BRIE, -5, 40);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(-6, item.sellIn);
        assertEquals(42, item.quality);
    }

    @Test
    void conjuredSulfuras() {
        Item item = createItem(CONJURED + SULFURAS, 5, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(5, item.sellIn);
        assertEquals(5, item.quality);

    }

    @Test
    void conjuredBackStagePassess() {
        Item item = new Item(CONJURED + BACK_STAGE_PASSES, 5, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(8, item.quality);

    }


}
