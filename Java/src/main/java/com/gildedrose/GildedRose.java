package com.gildedrose;

import com.gildedrose.itemprocessor.ItemProcessorFactory;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.asList(items).forEach(item -> ItemProcessorFactory.getProcessor(item).accept(item));
    }
}
