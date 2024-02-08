package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void testThatItemsQualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("Generic Item", 1, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Generic Item", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void testThatItemsQualityDecreases2FasterWhenSellDateHasPassed() {
        Item[] items = new Item[] { new Item("Generic Item", -1, 2) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Generic Item", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    public void testThatItemsQualityForItemThatImproveIncreases2FasterWhenSellDateHasPassed() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 2) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    public void testThatItemsQualityForItemThatImproveIsNeverGreaterThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 15, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    public void testThatSulfurasNeverChanges() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 15, 80) };
        GildedRose app = new GildedRose(items);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(15, app.items[0].sellIn);
    }

    @Test
    public void testThatAgedBrieQualityIncreasesAfterOneDay() {
        Item[] items = new Item[] { new Item("Aged Brie", 15, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    public void testThatBackstageQualityIncreasesBy1WhenSellDateGreaterThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(21, app.items[0].quality);
        assertEquals(11, app.items[0].sellIn);
    }

    @Test
    public void testThatBackstageQualityIncreases2FasterWhenSellDateLessThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(22, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
    }

    @Test
    public void testThatBackstageQualityIncreases3FasterWhenSellDateLessThan5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(23, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    public void testThatBackstageQualityIsZeroWhenAfterSellDate() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }
}
