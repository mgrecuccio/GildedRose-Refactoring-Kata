package com.gildedrose.itemprocessor;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

public class AgedBrieProcessor implements ItemProcessor {

    @Override
    public void accept(Item item) {
        if (ItemProcessor.canQualityIncrease(item.quality)) {
            item.quality++;
            doubleAmeliorationIfNeeded(item);
        }
        item.sellIn--;
    }

    private void doubleAmeliorationIfNeeded(Item item) {
        if (ItemProcessor.hasSellDatePassed(item.sellIn)) {
            item.quality++;
        }
    }

    @Override
    public boolean handle(String itemName) {
        return itemName.contains(ItemType.AGED_BRIE.getItemPrefix());
    }
}
