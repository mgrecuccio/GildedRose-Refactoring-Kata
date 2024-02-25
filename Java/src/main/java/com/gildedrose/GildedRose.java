package com.gildedrose;

import com.gildedrose.exception.InvalidItemNameException;
import com.gildedrose.exception.java8.Result;
import com.gildedrose.itemprocessor.ItemProcessor;
import com.gildedrose.itemprocessor.ItemProcessorFactory;

import java.util.stream.Stream;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Stream.of(items).forEach(GildedRose::processItem);
    }

    private static void processItem(Item item) {
        Result<ItemProcessor, InvalidItemNameException> attempt = Result.attempt(() -> ItemProcessorFactory.getProcessor(item.name));
        if (attempt.isSuccess()) {
            attempt.getValue().accept(item);
        } else {
            System.out.println("Impossible to process the Item: " + attempt.getError().getMessage());
        }
    }
}
