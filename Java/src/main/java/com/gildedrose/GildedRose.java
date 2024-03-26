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
        boolean isSulfuras = isSulfuras(item);

        updateQuality(item);
        updateSellIn(item, isSulfuras);
        if (isExpired(item))
            processExpiredItem(item);
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void processExpiredItem(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                break;  // Quality never changes for Sulfuras
            case "Aged Brie":
                if (item.quality < 50) {
                    increaseQuality(item);
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item.quality = 0;
                break;
            default:
                decreaseQuality(item);
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

    private void updateQuality(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Aged Brie":
                if (item.quality < 50) {
                    increaseQuality(item);
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
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
                break;
            default:
                if (item.quality > 0) {
                    decreaseQuality(item);
                }
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
