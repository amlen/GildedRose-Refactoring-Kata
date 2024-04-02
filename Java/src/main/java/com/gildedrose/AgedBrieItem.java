package com.gildedrose;

public class AgedBrieItem implements ItemUpdater{
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
