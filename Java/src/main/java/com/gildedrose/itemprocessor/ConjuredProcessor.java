package com.gildedrose.itemprocessor;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

public class ConjuredProcessor implements ItemProcessor {

    @Override
    public void accept(Item item) {
        item.quality -= 2;
        if (!ItemProcessor.canQualityDecrease(item.quality)) {
            item.quality = 0;
        }
        item.sellIn--;
    }

    @Override
    public boolean handle(String itemName) {
        return itemName.contains(ItemType.CONJURED.getItemPrefix());
    }
}
