//package com.gildedrose.itemprocessor;
//
//import com.gildedrose.exception.InvalidItemNameException;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertInstanceOf;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class ItemProcessorFactoryTest {
//
//    @Test
//    public void getItemProcessorTest() {
//        ItemProcessor itemProcessor = ItemProcessorFactory.getProcessor("Generic Product");
//        assertInstanceOf(GenericItemProcessor.class, itemProcessor);
//
//        itemProcessor = ItemProcessorFactory.getProcessor("Aged Brie");
//        assertInstanceOf(AgedBrieProcessor.class, itemProcessor);
//
//        itemProcessor = ItemProcessorFactory.getProcessor("Backstage passes to a TAFKAL80ETC concert");
//        assertInstanceOf(BackstageProcessor.class, itemProcessor);
//
//        itemProcessor = ItemProcessorFactory.getProcessor("Sulfuras, Hand of Ragnaros");
//        assertInstanceOf(SulfurasProcessor.class, itemProcessor);
//    }
//
//    @Test
//    public void testThatExceptionIsThrowWhenItemNameNotEmptyOrNull() {
//        assertThrows(InvalidItemNameException.class,
//            () -> ItemProcessorFactory.getProcessor(null));
//
//        assertThrows(InvalidItemNameException.class,
//            () -> ItemProcessorFactory.getProcessor(""));
//    }
//
//}
