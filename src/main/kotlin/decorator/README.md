# Decorator Pattern

- Another pattern using composition over inheritance
- A way to achieve OCP

# Imaginary Case

Imagine you work a web developer that works for Nike, When it was not famous. Your job is to program a website that
shows various types of Nike shoes and price.

With help of excellent UI/UX designer and co-workers, you managed to show awesome images of each shoe.

During the initial project, customization was excluded.

```kotlin
abstract class Shoe() {
    abstract fun cost()
}

class AirForce : Shoe() {
    ...
}

class Cortez : Shoe() {
    ...
}

class Jordan : Shoe() {
    ...
}
```

As Nike earns reputation with huge success of `Jordan`, More customers starts purchasing shoes. Later, Executives decide
to add customization options. Customization options include something like
`Chaning color of Shoes or Swoosh, Adding words or phrases and adding fancy tags`

So you took that new requirements and started modifying your code like

```kotlin
abstract class Shoe {
    abstract fun cost()
}

class AirForceWithWhiteColor : Shoe() {
    ...
}

class AirForceWithBlackColor : Shoe() {
    ...
}

class AirForceWithWhiteSwoosh : Shoe() {
    ...
}

class AirForceWithBlackSwoosh : Shoe() {
    ...
}

class AirForceWithBlackSwooshAndMJTags : Shoe() {

}

```

Soon you found out that this is going to be hopeless. This is going to be disaster writing all these variations of
shoes. Moreover, you also knew that new types of shoes will be dropped.

`You need to find a way to turn this nightmare around`

# Takeaway from the Imaginary Case

- Yes, again, Changes.

- What if you keep writing your code like that? Any problems?

1. Of course, maintenance nightmare
2. What if some types or some colors cannot be applied?
3. What if price of options change? find all the classes that use that option and change??

# Things that do not change

No matter how many options are added, shoes are shoes.

AirForce is still AirForce whether options are applied, colors are changed.

# Possible Solution1: Put Everything in superclass

As it seems obvious that nightmare is coming as more shoes and more options are likely to be added,
`You decided to put every option into superclass`, like the following:

```kotlin
abstract class Shoe {

    ...

    var hasColor: Boolean = false
    var color: String? = null

    var hasWord: Boolean = false
    var word: String? = null

    var hasTag: Boolean = false
    var tag: String? = null

    ...

}
```

Then based on this new fresh `superclass`, you start modifying `cost()` function

```kotlin
abstract class Shoe {

    ...

    fun cost(): Int {
        if (hasColor) {
            price += 30
        }
        if (hasWord) {
            price += 10
        }
        if (hasTag) {
            price += 20
        }
        return price
    }

    ...
}

```

No time! executives want this to be updated asap!

Lack of confidence...Why?

# Problems

This could be one solution, but lack of confidence implies some level of ambiguity, and a room for improvement as well.

What are some possible downsides of the approach above?

It could be something like this:

- Maybe some options cannot be applied?
- Or customers want same options more than once? (two words? more colors?)

What about technically?

- It is altering existing code!!!
- HAS-A relationship is here!
- The more options are added, the more code will be added into existing one!

# Using decorator!!

## OCP - Open Closed Principle

> Class Should be open for extension, but closed for modification

- Open: Feel free to extend with any new behavior
- Closed: Cannot let you alter existing code

## Problem with possible solution in OCP perspective

It definitely violates OCP. We want to keep things flexible while not touching existing code.

## Decorate? Decorate what?

Even though options are applied, shoes are still shoes: it does not change itself

Rather, we just decorate it while keeping itself.

For example, one customer want `Nike AirForce with white and black color, tags and words saying cool`

To do that we have to take this into steps. How do we do that?

1. Take Nike AirForce
2. Decorate it with white and black color
3. Decorate `2` with tags
4. Decorate `3` with a word `cool`

`Keep in mind that from 2 to 4, we still keep decorating as shoe`
`This also means that we have to see options as shoes, rather than looking at this as components of shoes`

We know from the case that inheritance does not fit very well. What about composition?

## Implementation

1. Create Nike AirForce object: Shoe object
2. Wrap it with colors: Shoe object
3. Wrap `2` with tags: Shoe object
4. Wrap `3` with word: Shoe object

`Decorators have the same supertype and we can have more than one decorators`


## What is Decorator Pattern?
> It attaches additional responsibilities to an object dynamically
> It provides a flexible alternative to subclassing for extending functionality
