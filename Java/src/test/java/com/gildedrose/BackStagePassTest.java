package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.update.QualityConfiguration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackStagePassTest extends GildedRoseSetup {

    @Test
    void increasesBy2When10DaysOrLess() {
        Item item = new Item(BACK_STAGE_PASSES, BACKSTAGE_PASSES_DOUBLE + 1, 3);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(10, item.sellIn);
        assertEquals(4, item.quality);
        app.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(6, item.quality);
        app.updateQuality();
        assertEquals(8, item.sellIn);
        assertEquals(8, item.quality);

    }
    @Test
    void increasesBy3When5DaysOrLess() {
        Item item = new Item(BACK_STAGE_PASSES, BACKSTAGE_PASSES_TRIPLE + 1, 3);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(5, item.sellIn);
        assertEquals(5, item.quality);
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(8, item.quality);
        app.updateQuality();
        assertEquals(3, item.sellIn);
        assertEquals(11, item.quality);

    }

    @Test
    void dropsToZero() {
        Item item = createItem(BACK_STAGE_PASSES, 1, 3);
        GildedRose app = createGildedRose(item);
        app.updateQuality();
        assertEquals(0, item.sellIn);
        assertEquals(6, item.quality);
        app.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
        app.updateQuality();
        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);

    }

}
