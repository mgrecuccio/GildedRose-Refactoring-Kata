package com.gildedrose.itemprocessor;

import com.gildedrose.Item;
import com.gildedrose.exception.InvalidItemNameException;

import java.util.Arrays;
import java.util.List;

public class ItemProcessorFactory {

    private final static List<ItemProcessor> processors = Arrays.asList(
        new SulfurasProcessor(),
        new BackstageProcessor(),
        new AgedBrieProcessor()
    );

    public static ItemProcessor getProcessor(Item item) {
        final String itemName = item.name;
        validateItemName(itemName);

        return processors.stream()
            .filter(p -> p.handle(itemName))
            .findFirst()
            .orElseGet(() -> new GenericItemProcessor());
    }

    private static void validateItemName(String itemName) {
        if (itemName == null || itemName.isEmpty())
            throw new InvalidItemNameException("The item name must not be null or empty.");
    }
}
