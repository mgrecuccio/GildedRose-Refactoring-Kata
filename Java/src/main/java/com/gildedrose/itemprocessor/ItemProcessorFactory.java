package com.gildedrose.itemprocessor;

import com.gildedrose.exception.InvalidItemNameException;

import java.util.Arrays;
import java.util.List;

public class ItemProcessorFactory {

    private final static List<ItemProcessor> processors = Arrays.asList(
        new SulfurasProcessor(),
        new BackstageProcessor(),
        new AgedBrieProcessor(),
        new ConjuredProcessor()
    );

    public static ItemProcessor getProcessor(String itemName) {
        if(itemName == null || itemName.isEmpty()) throw new InvalidItemNameException("Invalid item name");

        return processors.stream()
            .filter(p -> p.handle(itemName))
            .findFirst()
            .orElseGet(() -> new GenericItemProcessor());
    }
}
