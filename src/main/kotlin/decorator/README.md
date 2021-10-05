# Decorator Pattern
- Another pattern using composition over inheritance
- A way to achieve OCP

# Imaginary Case
Imagine you work a web developer that works for Nike, When it was not famous.
Your job is to program a website that shows various types of Nike shoes and price.

With help of excellent UI/UX designer and co-workers, 
you managed to show awesome images of each shoe.

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

As Nike earns reputation with huge success of `Jordan`, More customers starts purchasing shoes.
Later, Executives decide to add customization options. Customization options include something like
`Chaning color of Shoes or Swoosh, Adding words or phrases and adding fancy tags`

So you took that new requirements and started modifying your code like
```kotlin
abstract class Shoe {
    abstract fun cost()   
}

class AirForceWithWhiteColor: Shoe() {
    ...
}

class AirForceWithBlackColor: Shoe() {
    ...
}

class AirForceWithWhiteSwoosh: Shoe() {
    ...
}

class AirForceWithBlackSwoosh: Shoe() {
    ...
}

class AirForceWithBlackSwooshAndMJTags: Shoe() {
    
}

```

Soon you found out that this is going to be hopeless.
This is going to be disaster writing all these variations of shoes.
Moreover, you also knew that new types of shoes will be dropped.

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


# Possible Solution1


# Problems


# Using decorator!!


# OCP
> Class Should be open for extension, but closed for modification

- Open: Feel free to extend with any new behavior
- Closed: Cannot let you alter existing code
