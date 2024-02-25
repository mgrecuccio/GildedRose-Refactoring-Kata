package com.gildedrose.exception.java8;

@FunctionalInterface
public interface CheckedSupplier<V, E extends Throwable> {

    V get() throws E;

}
