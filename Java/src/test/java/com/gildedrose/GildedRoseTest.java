package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    GildedRose gildedRose;

    @BeforeEach
    void setup(){
        gildedRose = new GildedRose();
    }

    @Test
    void lowers_quality_and_sellIn_values_of_every_item_at_the_end_of_each_day() {
        Item[] items = new Item[] { new ItemBuilder().name("Any Item").toBeSoldIn(10).quality(10).build() };

        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(9, gildedRose.getItems()[0].sellIn);
        assertEquals(9, gildedRose.getItems()[0].quality);
    }

    @Test
    void lowers_quality_twice_as_fast_when_past_expiration_date() {
        Item[] items = new Item[] { new ItemBuilder().name("Any Item").pastExpirationDate().quality(10).build() };

        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(-1, gildedRose.getItems()[0].sellIn);
        assertEquals(8, gildedRose.getItems()[0].quality);
    }

    @Test
    void never_lowers_quality_value_below_zero() {
        Item[] items = new Item[] { new ItemBuilder().name("Any Item").toBeSoldIn(10).quality(0).build() };

        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(9, gildedRose.getItems()[0].sellIn);
        assertEquals(0, gildedRose.getItems()[0].quality);
    }

    @Test
    void increases_aged_brie_quality_at_the_end_of_each_day() {
        Item[] items = new Item[] { new ItemBuilder().name("Aged Brie").toBeSoldIn(10).quality(10).build() };

        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(9, gildedRose.getItems()[0].sellIn);
        assertEquals(11, gildedRose.getItems()[0].quality);
    }

    @Test
    void never_increases_aged_brie_quality_above_50() {
        Item[] items = new Item[] { new ItemBuilder().name("Aged Brie").toBeSoldIn(10).quality(50).build() };

        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(9, gildedRose.getItems()[0].sellIn);
        assertEquals(50, gildedRose.getItems()[0].quality);
    }

    @Test
    void never_lowers_sulfuras_quality_and_sellIn_values() {
        Item[] items = new Item[] { new ItemBuilder().name("Sulfuras, Hand of Ragnaros").toBeSoldIn(10).quality(10).build() };
        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(10, gildedRose.getItems()[0].sellIn);
        assertEquals(10, gildedRose.getItems()[0].quality);
    }

    @Test
    void increases_backstage_passes_quality_at_the_end_of_each_day() {
        Item[] items = new Item[] { new ItemBuilder().name("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(20).quality(10).build() };

        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(19, gildedRose.getItems()[0].sellIn);
        assertEquals(11, gildedRose.getItems()[0].quality);
    }

    @Test
    void never_increases_backstage_passes_quality_above_50() {
        Item[] items = new Item[] { new ItemBuilder().name("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(20).quality(50).build() };
        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(19, gildedRose.getItems()[0].sellIn);
        assertEquals(50, gildedRose.getItems()[0].quality);
    }

    @Test
    void increases_backstage_passes_quality_twice_as_fast_when_sellIn_value_is_equal_or_less_than_10() {
        Item[] items = new Item[] { new ItemBuilder().name("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(10).quality(10).build() };
        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(9, gildedRose.getItems()[0].sellIn);
        assertEquals(12, gildedRose.getItems()[0].quality);
    }

    @Test
    void increases_backstage_passes_quality_thrice_as_fast_when_sellIn_value_is_equal_or_less_than_5() {
        Item[] items = new Item[] { new ItemBuilder().name("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(5).quality(10).build() };
        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(4, gildedRose.getItems()[0].sellIn);
        assertEquals(13, gildedRose.getItems()[0].quality);
    }

    @Test
    void lowers_backstage_passes_quality_to_zero_when_past_expiration_date() {
        Item[] items = new Item[] { new ItemBuilder().name("Backstage passes to a TAFKAL80ETC concert").pastExpirationDate().quality(10).build() };
        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(-1, gildedRose.getItems()[0].sellIn);
        assertEquals(0, gildedRose.getItems()[0].quality);
    }

    @Test
    void lowers_conjured_mana_cake_quality_twice_as_fast() {
        Item[] items = new Item[] { new ItemBuilder().name("Conjured Mana Cake").toBeSoldIn(10).quality(10).build() };
        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(9, gildedRose.getItems()[0].sellIn);
        assertEquals(8, gildedRose.getItems()[0].quality);
    }

    @Test
    void never_lowers_conjured_mana_cake_quality_below_zero() {
        Item[] items = new Item[] { new ItemBuilder().name("Conjured Mana Cake").toBeSoldIn(10).quality(0).build() };
        gildedRose.setItems(items);
        gildedRose.updateQuality();

        assertEquals(9, gildedRose.getItems()[0].sellIn);
        assertEquals(0, gildedRose.getItems()[0].quality);
    }

}
