package com.gildedrose;

public class ConjuredItem implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;

        if (item.quality > 0) {
            decreaseQuality(item);
        }

        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 2;
    }
}
