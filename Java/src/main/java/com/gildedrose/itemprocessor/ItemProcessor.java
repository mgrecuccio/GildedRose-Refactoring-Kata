package com.gildedrose.itemprocessor;

import com.gildedrose.Item;

import java.util.function.Consumer;

public abstract class ItemProcessor implements Consumer<Item> {

    public static boolean hasSellDatePassed(int sellIn) {
        return sellIn <= 0;
    }

    public static boolean canQualityIncrease(int quality) {
        return quality < 50;
    }

    public static boolean canQualityDecrease(int quality) {
        return quality > 0;
    }
}
