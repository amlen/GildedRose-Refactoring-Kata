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
        ItemUpdater updater = createItemUpdater(item);
        updater.update(item);
    }

    private ItemUpdater createItemUpdater(Item item) {
        switch (item.name) {
            case SulfurasItem.NAME:
                return new SulfurasItem();
            case AgedBrieItem.NAME:
                return new AgedBrieItem();
            case BackstagePassesItem.NAME:
                return new BackstagePassesItem();
            case ConjuredItem.CONJURED:
                return new ConjuredItem();
            default:
                return new DefaultItem();
        }
    }

}
