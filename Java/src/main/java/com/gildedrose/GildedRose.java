package com.gildedrose;

class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured";

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
            case SULFURAS:
                return new SulfurasItem();
            case AGED:
                return new AgedBrieItem();
            case BACKSTAGE:
                return new BackstagePassesItem();
            case CONJURED:
                return new ConjuredItem();
            default:
                return new DefaultItem();
        }
    }

}
