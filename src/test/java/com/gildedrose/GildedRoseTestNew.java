package com.gildedrose;

import org.example.gildedrose.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest2 {

    @Test
    void qualityShouldNeverBeNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].getQuality(), 0);
    }

    @Test
    void qualityShouldDecreaseTwiceAsFastAfterSellInHasPassed() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].getQuality(), 8);
    }

    @Test
    void sellInShouldDecrease() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].getSellIn(), -1);
    }

    @Test
    void qualityShouldNeverBeGreaterThanFifty() {
        Item[] items = new Item[] { new AgedBrieItem("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].getQuality(), 50);
    }

    @Test
    void agedBrieShouldIncreaseQuality() {
        Item[] items = new Item[] { new AgedBrieItem("Aged Brie", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].getQuality(), 50);
    }

    @Test
    void sulfurasShouldNotChangeSellInOrQuality() {
        Item[] items = new Item[] { new SulfurasItem("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].getSellIn(), 10);
        assertEquals(items[0].getQuality(), 80);
    }

    @Test
    void backstagePassesIncreaseByTwo() {
        Item[] items = new Item[] { new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].getQuality(), 22);
    }

    @Test
    void backstagePassesIncreaseByThree() {
        Item[] items = new Item[] { new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].getQuality(), 23);
    }

    @Test
    void backstagePassesDecreaseToZero() {
        Item[] items = new Item[] { new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].getQuality(), 0);
    }


    @Test
    void conjuredItemsDegradeQualityTwiceAsFast() {
        Item[] items = new Item[] { new ConjuredItem("Conjured Item", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].getQuality(), 18);
    }
}
