package com.gildedrose;

import com.gildedrose.exception.InvalidItemNameException;
import com.gildedrose.exception.java20.Failure;
import com.gildedrose.exception.java20.Success;
import com.gildedrose.exception.java20.Try;
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
        //Stream.of(items).forEach(GildedRose::processItem);
        Stream.of(items).forEach(GildedRose::process);
    }

    /**
     * Process with Java21
     * @param item
     */
    private static void process(Item item) {
        var execution = Try.apply(() -> ItemProcessorFactory.getProcessor(item.name));
        switch (execution) {
            case Success<ItemProcessor> success -> success.getValue().accept(item);
            case Failure<ItemProcessor> failure -> System.out.println("Exception: " + failure.getException().getMessage());
        }
    }

    /**
     * Process with Java 8
     * @param item
     */
    private static void processItem(Item item) {
        Result<ItemProcessor, InvalidItemNameException> attempt = Result.attempt(() -> ItemProcessorFactory.getProcessor(item.name));
        if (attempt.isSuccess()) {
            attempt.getValue().accept(item);
        } else {
            System.out.println("Impossible to process the Item: " + attempt.getError().getMessage());
        }
    }
}
