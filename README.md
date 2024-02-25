# Implementation of the Gilded Rose Refactoring Kata

This is a Java implementation of the famous "Gilded Rose Refactoring Kata" exercise. The [original repository](https://github.com/emilybache/GildedRose-Refactoring-Kata) contains the full explication and the code base in multiple programming languages.

## Java implementation

The implementation is based on the following concepts:

- [TDD](https://en.wikipedia.org/wiki/Test-driven_development)
- [Strategy pattern](https://en.wikipedia.org/wiki/Strategy_pattern)
- [Factory pattern](https://en.wikipedia.org/wiki/Factory_method_pattern)
- [Error handling](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)


## Fundamentals

I categorized the items in 5 categories:

- Aged Brie
- Legend
- Backstage
- Conjured
- Generic

The business logic of each type is implemented in the specific processor (strategy pattern). The processors are instantiated by the ItemProcessorFactory (factory pattern).
The Exception Handling shows how errors and exceptions should be managed in Functional Programming.