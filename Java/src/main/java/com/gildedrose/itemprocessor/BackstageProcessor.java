package com.gildedrose.itemprocessor;

import com.gildedrose.Item;

public class BackstageProcessor extends ItemProcessor {

    @Override
    public void accept(Item item) {
        if(hasSellDatePassed(item.sellIn)) {
            item.quality = 0;
        } else if(canQualityIncrease(item.quality)) {
           int ameliorationFactor = computeAmeliorationFactor(item.sellIn);
           if(canQualityIncrease(item.quality+ameliorationFactor)) {
               item.quality+=ameliorationFactor;
           } else {
               item.quality = 50;
           }
        }
        item.sellIn--;
    }

    private int computeAmeliorationFactor(int sellIn) {
        if(sellIn <= 5)
            return 3;
        if(sellIn <= 10)
            return 2;
        return 1;
    }
}
