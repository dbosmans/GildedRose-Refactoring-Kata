package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("new implementation")
public class ConjuredTest extends GildedRoseSetup {

    @Test
    void decreaseIsDoubled() {
        Item item = new Item(CONJURED, 5, 5);
        GildedRose app = new GildedRose(items(item));
        app.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(3, item.quality);
    }

    @Test
    void decreaseIsDoubleDoubled_afterSellByDate() {
        Item item = new Item(CONJURED, 0, 5);
        GildedRose app = new GildedRose(items(item));
        app.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(1, item.quality);
    }





}
