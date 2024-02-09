package com.gildedrose.itemprocessor;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

public class SulfurasProcessor implements ItemProcessor {

    @Override
    public void accept(Item item) {
        // do nothing
    }

    @Override
    public boolean handle(String itemName) {
        return itemName.contains(ItemType.LEGEND.getItemPrefix());
    }
}
