package com.gildedrose.itemprocessor;

import com.gildedrose.Item;

import java.util.function.Consumer;

public interface ItemProcessor extends Consumer<Item> {

    default boolean handle(String itemName) {
        return false;
    }

    static boolean hasSellDatePassed(int sellIn) {
        return sellIn <= 0;
    }

    static boolean canQualityIncrease(int quality) {
        return quality < 50;
    }

    static boolean canQualityDecrease(int quality) {
        return quality > 0;
    }
}
