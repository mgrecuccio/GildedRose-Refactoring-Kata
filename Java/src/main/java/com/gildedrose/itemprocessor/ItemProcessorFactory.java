package com.gildedrose.itemprocessor;

import com.gildedrose.exception.InvalidItemNameException;

public class ItemProcessorFactory {

    public static ItemProcessor getProcessor(String itemName) {
        validateItemName(itemName);

        switch (itemName) {
            case "Aged Brie":
                return new AgedBrieProcessor();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstageProcessor();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasProcessor();
            default:
                return new GenericItemProcessor();
        }
    }

    private static void validateItemName(String itemName) {
        if(itemName == null || itemName.isEmpty())
            throw new InvalidItemNameException("Hey");
    }
}
