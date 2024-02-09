package com.gildedrose.itemprocessor;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

public class BackstageProcessor implements ItemProcessor {

    @Override
    public void accept(Item item) {
        if (ItemProcessor.hasSellDatePassed(item.sellIn)) {
            item.quality = 0;
        } else if (ItemProcessor.canQualityIncrease(item.quality)) {
            int ameliorationFactor = computeAmeliorationFactor(item.sellIn);
            if (ItemProcessor.canQualityIncrease(item.quality + ameliorationFactor)) {
                item.quality += ameliorationFactor;
            } else {
                item.quality = 50;
            }
        }
        item.sellIn--;
    }

    private int computeAmeliorationFactor(int sellIn) {
        if (sellIn <= 5)
            return 3;
        if (sellIn <= 10)
            return 2;
        return 1;
    }

    @Override
    public boolean handle(String itemName) {
        return itemName.contains(ItemType.BACKSTAGE.getItemPrefix());
    }
}
