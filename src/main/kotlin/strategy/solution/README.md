# Solution

## Recap
From the previous, It is obvious that
1. Character's attribute keeps changing or being added
2. We still want to keep things flexible amid changing
3. IS-A relationship is not well suited in this case


## Ingredients to achieve goal
1. `Identifying what's changing`
2. `Encapsulate what's changing`
    - Meaning `separate from what stay's the same`
    

## What's changing?
What's constantly changing is character's behavior based on situation


## How to encapsulate it?
IS-A relationship has one disadvantage that it cannot be extended.

We have one relationship called `HAS-A`, or Composition

This simply means one class has other classes or interfaces as variables, not being extended

Example of `HAS-A` relationship
```kotlin
interface BarkBehavior {
    fun bark()
}

class Wolf{
    
    var barkBehavior: BarkBehavior? = null

    fun setBarkBehavior(behavior: BarkBehavior) {
        this.barkBehavior = behavior
    }

    fun bark() = barkBehavior?.bark()
}

class WolfBark : BarkBehavior {
    
    override fun bark() = println("We Howl!")
    
}

fun main() {

    val animal = Wolf()
    animal.setBarkBehavior(WolfBark())
    animal.bark()
}
```

Think about advantages that `HAS-A` relationship has.
1. If we want to change behavior(In this case, bark behavior), we can change behavior dynamically, thus flexible
2. Wolf class does not know what actual implementation is until `setBarkBehavior()` is called - encapsulated



## Reworking code of our Character
```kotlin
abstract class Character(private var behavior: SituationalBehavior?) {

    fun setBehavior(behavior: SituationalBehavior) {
        this.behavior = behavior
    }

    fun talk() {
        behavior?.talk()
    }
    
}
```

```kotlin
class Dwight(behavior: SituationalBehavior?) : Character(behavior) {

    //Character specific behaviors here
}

interface SituationalBehavior {

    fun move()

    fun talk()
}

class DwightAngry: SituationalBehavior {
    override fun move() {
        println("Running")
    }

    override fun talk() {
        println("Michael!!!")
    }
}

class DwightHappy : SituationalBehavior {

    override fun move() {
        println("HA HA HA HA")
    }

    override fun talk() {
        println("I am sad")
    }
}

fun main() {
   val dwight = Dwight(DwightAngry())
   dwight.setBehavior(DwightHappy())
}
```


## Result
- By not defining behaviors(things that change) in abstract class, and have it defined in interface,
`We can interchangeably change character's behavior`

- `When more situations are added, We still do not need to modify working code.`
   - Rather, we define new situating with implementation, and call `setBehavior()`
   





## So, What is Strategy Pattern?
- From the Book
   - `Defines a family of algorithms, encapsulated each one, and makes them interchangeable`
   - `It lets the algorithm vary independelty`

- Strategy pattern offers a structure to easily change
  behaviors(family of algorithms) that an object perform which vary from client
  by using `HAS-A`, or Composition




# What's next
:point_right: [Singleton](../../singleton)