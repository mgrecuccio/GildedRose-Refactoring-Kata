package com.gildedrose.exception.java20;

@FunctionalInterface
public interface CheckedSupplier<T> {
    T get() throws Exception;

}
