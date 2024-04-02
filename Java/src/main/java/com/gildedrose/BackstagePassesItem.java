package com.gildedrose;

public class BackstagePassesItem implements ItemUpdater{
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";
    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality < MAX_QUALITY) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }
}
