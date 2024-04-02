package com.gildedrose;

public class AgedBrieItem implements ItemUpdater {
    public static final String NAME = "Aged Brie";

    @Override
    public void update(Item item) {
        item.sellIn--;

        if (item.quality < MAX_QUALITY) {
            increaseQuality(item, 1);
        }

        if (item.sellIn < 0 && item.quality < MAX_QUALITY) {
            increaseQuality(item, 1);
        }
    }

    private void increaseQuality(Item item, int i) {
        item.quality = item.quality + i;
    }
}
