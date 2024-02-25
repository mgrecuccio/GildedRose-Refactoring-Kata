package com.gildedrose.exception.java8;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * Result which can either be initialized with a value of type V via Result.success,
 * or an error of type E via Result.failure.
 *
 * @param <V> is case of success
 * @param <E> in case of error
 */
public class Result<V, E extends Throwable> {

    private final V value;
    private final E error;

    public Result(V value, E error) {
        this.value = value;
        this.error = error;
    }

    public static <V, E extends Throwable> Result<V, E> failure(E error) {
        return new Result<>(null, Objects.requireNonNull(error));
    }

    public static <V, E extends Throwable> Result<V, E> success(V value) {
        return new Result<>(Objects.requireNonNull(value), null);
    }

    public boolean isSuccess() {
        return value != null;
    }

    public V getValue() {
        return value;
    }

    public E getError() {
        return error;
    }

    /**
     * It wraps Result with the value V if the operation is successful or with the error E in case of failure.
     * @param supplier: allows us to write lambdas as shorthand for instances of that interface
     * @return
     * @param <V>
     * @param <E>
     */
    public static <V, E extends Throwable> Result<V, E> attempt(
        CheckedSupplier<? extends V, ? extends E> supplier
    ) {
        try {
            return Result.success(supplier.get());
        } catch (Throwable e) {
            E error = (E) e;
            return Result.failure(error);
        }
    }

    /**
     * For API for transformations in cas of your execution has a return value: map to return a new wrapper for the
     * transformed value. Unless it's an error, in which case it should return a wrapped error.
     * @param mapper
     * @return
     * @param <T>
     */
    public <T> Result<T, E> map(Function<? super V, ? extends T> mapper) {
        return Optional.ofNullable(error)
            .map(e -> Result.<T, E>failure(e))
            .orElseGet(() -> Result.success(mapper.apply(value)));
    }

    /**
     * To unwrap the Result: either returns the value, or throws the error.
     * @return
     * @throws E
     */
    public V orElseThrow() throws E {
        return Optional.ofNullable(value).orElseThrow(() -> error);
    }
}
