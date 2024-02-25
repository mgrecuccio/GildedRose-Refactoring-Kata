package com.gildedrose.itemprocessor;

import com.gildedrose.exception.InvalidItemNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemProcessorFactoryTest {

    @Test
    public void getItemProcessorTest() {
        ItemProcessor itemProcessor = ItemProcessorFactory.getProcessor("Generic Product");
        assertTrue(itemProcessor instanceof GenericItemProcessor);

        itemProcessor = ItemProcessorFactory.getProcessor("Aged Brie");
        assertTrue(itemProcessor instanceof AgedBrieProcessor);

        itemProcessor = ItemProcessorFactory.getProcessor("Backstage passes to a TAFKAL80ETC concert");
        assertTrue(itemProcessor instanceof BackstageProcessor);

        itemProcessor = ItemProcessorFactory.getProcessor("Sulfuras, Hand of Ragnaros");
        assertTrue(itemProcessor instanceof SulfurasProcessor);

        itemProcessor = ItemProcessorFactory.getProcessor("Conjured Mana Cake");
        assertTrue(itemProcessor instanceof ConjuredProcessor);
    }

    @Test
    public void testThatExceptionIsThrowWhenItemNameNotEmptyOrNull() {
        assertThrows(InvalidItemNameException.class,
            () -> ItemProcessorFactory.getProcessor(null));

        assertThrows(InvalidItemNameException.class,
            () -> ItemProcessorFactory.getProcessor(""));
    }
}
