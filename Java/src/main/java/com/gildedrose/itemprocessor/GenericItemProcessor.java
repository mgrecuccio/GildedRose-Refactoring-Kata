package com.gildedrose.itemprocessor;

import com.gildedrose.Item;

public class GenericItemProcessor extends ItemProcessor {

    @Override
    public void accept(Item item) {
        if (canQualityDecrease(item.quality)) {
            item.quality--;
            doubleDeteriorationIfNeeded(item);
        }
        item.sellIn--;
    }

    private void doubleDeteriorationIfNeeded(Item item) {
        if (hasSellDatePassed(item.sellIn)) {
            item.quality--;
        }
    }
}
