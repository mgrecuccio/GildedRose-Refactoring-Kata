package com.gildedrose.exception.java20;

public final class Success<T> extends Try<T> {

    private final T value;

    public Success(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
