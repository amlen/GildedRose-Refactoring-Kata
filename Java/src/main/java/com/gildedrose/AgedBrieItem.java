package com.gildedrose;

public class AgedBrieItem implements ItemUpdater{
    public static final String NAME = "Aged Brie";
    @Override
    public void update(Item item) {
        item.sellIn--;

        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }

        if (item.sellIn < 0 && item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }
}
