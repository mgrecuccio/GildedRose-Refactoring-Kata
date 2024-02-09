package com.gildedrose.itemprocessor;

import com.gildedrose.Item;

public class GenericItemProcessor implements ItemProcessor {

    @Override
    public void accept(Item item) {
        if (ItemProcessor.canQualityDecrease(item.quality)) {
            item.quality--;
            doubleDeteriorationIfNeeded(item);
        }
        item.sellIn--;
    }

    private void doubleDeteriorationIfNeeded(Item item) {
        if (ItemProcessor.hasSellDatePassed(item.sellIn)) {
            item.quality--;
        }
    }
}
