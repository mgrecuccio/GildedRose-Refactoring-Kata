package com.gildedrose.itemprocessor;

import com.gildedrose.Item;

public class AgedBrieProcessor extends ItemProcessor {

    @Override
    public void accept(Item item) {
        if (canQualityIncrease(item.quality)) {
            item.quality++;
            doubleAmeliorationIfNeeded(item);
        }
        item.sellIn--;
    }

    private void doubleAmeliorationIfNeeded(Item item) {
        if (hasSellDatePassed(item.sellIn)) {
            item.quality++;
        }
    }
}
