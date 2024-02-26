package com.gildedrose.exception.java20;

public final class Failure<T> extends Try<T> {

    private final Exception exception;

    public Failure(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }
}
