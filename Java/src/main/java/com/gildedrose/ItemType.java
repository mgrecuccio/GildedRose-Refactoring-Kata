package com.gildedrose;

public enum ItemType {

    AGED_BRIE("Aged Brie"),

    LEGEND("Sulfuras"),

    BACKSTAGE("Backstage passes");

    private final String itemPrefix;

    ItemType(String itemPrefix) {
        this.itemPrefix = itemPrefix;
    }

    public String getItemPrefix() {
        return itemPrefix;
    }
}
