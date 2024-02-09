//package com.gildedrose.itemprocessor;
//
//import com.gildedrose.Item;
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
//        ItemProcessor itemProcessor = ItemProcessorFactory.getProcessor(new Item("Generic Product", 0, 0));
//        assertInstanceOf(GenericItemProcessor.class, itemProcessor);
//
//        itemProcessor = ItemProcessorFactory.getProcessor(new Item("Aged Brie", 0, 0));
//        assertInstanceOf(AgedBrieProcessor.class, itemProcessor);
//
//        itemProcessor = ItemProcessorFactory.getProcessor(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0));
//        assertInstanceOf(BackstageProcessor.class, itemProcessor);
//
//
//        itemProcessor = ItemProcessorFactory.getProcessor(new Item("Sulfuras, Hand of Ragnaros", 0, 0));
//        assertInstanceOf(SulfurasProcessor.class, itemProcessor);
//
//    }
//
//    @Test
//    public void testThatExceptionIsThrowWhenItemNameNotEmptyOrNull() {
//        assertThrows(InvalidItemNameException.class,
//            () -> ItemProcessorFactory.getProcessor(new Item(null, 0, 0)));
//
//        assertThrows(InvalidItemNameException.class,
//            () -> ItemProcessorFactory.getProcessor(new Item("", 0, 0)));
//    }
//}
