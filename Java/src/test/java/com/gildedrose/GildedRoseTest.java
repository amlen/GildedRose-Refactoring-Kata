package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_NormalItem_DecreasesQualityAndSellInByOne() {
        int sellIn = 5;
        int quality = 7;
        Item item = new Item("Elixir of the Mongoose", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();

        assertEquals(sellIn - 1, item.sellIn);
        assertEquals(quality - 1, item.quality);
    }

    @Test
    void updateQuality_SellInHasPassed_QualityDegradesTwice() {
        int sellIn = 0;
        int quality = 4;
        Item item = new Item("Standard Item", sellIn, quality);
        GildedRose subject = new GildedRose(new Item[]{item});

        subject.updateInventory();

        assertEquals(quality - 2, item.quality);
    }

    @Test
    void updateQuality_ItemWithZeroQuality_QualityIsNeverNegative() {
        int sellIn = 4;
        int quality = 0;
        Item item = new Item("Standard Item", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();

        assertEquals(quality, item.quality);
    }

    @Test
    public void updateQuality_AgedBrieItem_IncreasesQualityAndDecreasesSellIn() {
        int sellIn = 5;
        int quality = 6;
        Item item = new Item("Aged Brie", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();

        assertEquals(quality + 1, item.quality);
        assertEquals(sellIn - 1, item.sellIn);
    }

    @Test
    void updateQuality_Item_IsNeverGreaterThanFifty() {
        int sellIn = 0;
        int quality = 50;
        Item item = new Item("Aged Brie", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();

        assertEquals(item.quality, quality);
    }

    @Test
    void updateQuality_AgedItem_qualityIncreasesTwiceAsFastPastSellIn() {
        int sellIn = 0;
        int quality = 6;
        Item item = new Item("Aged Brie", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();

        assertEquals(item.quality, quality + 2);
    }


    @Test
    public void updateQuality_SulfurasItem_NoChangeInQualityOrSellIn() {

        int sellIn = -1;
        int quality = 80;
        Item item = new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();

        assertEquals(quality, item.quality);
        assertEquals(sellIn, item.sellIn);
    }

    @Test
    public void updateQuality_SulfurasItem_NoChangeInQualityOrSellIn1() {

        int sellIn = 1;
        int quality = 80;
        Item item = new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();

        assertEquals(quality, item.quality);
        assertEquals(sellIn, item.sellIn);
    }

    @Test
    public void updateQuality_BackstagePassesItem_IncreasesQualityAndDecreasesSellIn() {
        int sellIn = 15;
        int quality = 20;
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();
        assertEquals(quality + 1, item.quality);
        assertEquals(sellIn - 1, item.sellIn);
    }

    @Test
    public void updateQuality_BackstagePassesItemWithSellInTenOrLess_IncreasesQualityByTwoAndDecreasesSellInByOne() {
        int sellIn = 10;
        int quality = 20;
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();
        assertEquals(quality + 2, item.quality);
        assertEquals(sellIn - 1, item.sellIn);
    }

    @Test
    public void updateQuality_BackstagePassesItemWithSellInFiveOrLess_IncreasesQualityByThreeAndDecreasesSellInByOne() {
        int sellIn = 5;
        int quality = 47;
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();
        assertEquals(quality + 3, item.quality);
        assertEquals(sellIn - 1, item.sellIn);
    }

    @Test
    public void updateQuality_BackstagePassesItemWithSellInZero_QualityDropsToZeroAndSellInDecreaseByOne() {
        int sellIn = 0;
        int quality = 20;
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventory();
        assertEquals(0, item.quality);
        assertEquals(sellIn - 1, item.sellIn);
    }

}



