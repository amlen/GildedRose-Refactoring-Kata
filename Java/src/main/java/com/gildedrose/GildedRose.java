package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        boolean isAgedBrie = item.name.equals("Aged Brie");
        boolean isBackstagePasses = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean isSulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");

        updateQuality(item, isAgedBrie, isBackstagePasses, isSulfuras);

        updateSellIn(item, isSulfuras);

        processExpiredItem(item, isAgedBrie, isBackstagePasses, isSulfuras);
    }

    private void processExpiredItem(Item item, boolean isAgedBrie, boolean isBackstagePasses, boolean isSulfuras) {
        if (item.sellIn < 0) {
            if (!isAgedBrie) {
                if (!isBackstagePasses) {
                    if (item.quality > 0) {
                        if (!isSulfuras) {
                            decreaseQuality(item);
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void updateSellIn(Item item, boolean isSulfuras) {
        if (!isSulfuras) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateQuality(Item item, boolean isAgedBrie, boolean isBackstagePasses, boolean isSulfuras) {
        if (!isAgedBrie && !isBackstagePasses) {
            if (item.quality > 0) {
                if (!isSulfuras) {
                    decreaseQuality(item);
                }
            }
        } else {
            if (item.quality < 50) {
                increaseQuality(item);

                if (isBackstagePasses) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            increaseQuality(item);
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            increaseQuality(item);
                        }
                    }
                }
            }
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
