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
        boolean isAgedBrie = isAgedBrie(item);
        boolean isBackstagePasses = isBackstagePasses(item);
        boolean isSulfuras = isSulfuras(item);

        updateQuality(item, isAgedBrie, isBackstagePasses, isSulfuras);
        updateSellIn(item, isSulfuras);
        if (isExpired(item))
            processExpiredItem(item, isAgedBrie, isBackstagePasses, isSulfuras);
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void processExpiredItem(Item item, boolean isAgedBrie, boolean isBackstagePasses, boolean isSulfuras) {
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

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void updateSellIn(Item item, boolean isSulfuras) {
        if (!isSulfuras) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateQuality(Item item, boolean isAgedBrie, boolean isBackstagePasses, boolean isSulfuras) {
        if (isAgedBrie) {
            if (item.quality < 50) {
                increaseQuality(item);
            }
        } else if (isBackstagePasses) {
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

            if (item.quality < 50) {
                increaseQuality(item);
            }

        } else {
            if (item.quality > 0) {
                if (isSulfuras) {
                    return;
                }
                decreaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
