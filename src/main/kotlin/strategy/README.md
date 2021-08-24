# Strategy Pattern

## Background Information

Let's think about the case which your developer team decide to create game Characters from `The Office`.

Your job is to create a characters that move, talk.

So, You create a base class called `Chracter`

```kotlin
abstract class Character {
    
    abstract fun move()
    
    abstract fun talk()
}
```

Based on this, you create a character called `Michael`, `Dwight`, `Jim` and `Toby` and let these classes
inherit `Character`


### Next
[Problem with Inheritance](./problem_inheritance)





### Link
[Strategy Pattern](https://refactoring.guru/design-patterns/strategy)

[PatternCraft - Strategy Pattern](https://www.youtube.com/watch?v=MOEsKHqLiBM)

[When to use an abstract class vs. interface](https://www.infoworld.com/article/2928719/when-to-use-an-abstract-class-vs-interface-in-csharp.html)

[Using an Interface vs. Abstract](https://www.baeldung.com/java-interface-vs-abstract-class)