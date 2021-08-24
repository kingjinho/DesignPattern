# Problem with interface

## Previous

We successfully launched initial version of Game.

Then the needs for the game had changed, so We finally made some changes.

However, during the modification, We discovered that inheritance was causing trouble.

To resolve that issue, We decide to solve using interface.

### Implementation

1. Create an interface called `Behavior`
2. In `Behavior` interface, `add methods(bahaviors) that each character should implement`
    ```kotlin
    interface Behavior {
    
        fun move()
    
        fun talk()
    }
    ```
3. On each character, implement `Behavior` methods
   ```kotlin
   class Dwight : Character(), Behavior {
   
       override fun move() {
           println("Walking with confidence")
       }
   
       override fun talk(situation: Situation) {
           when(situation) {
                Situation.SERIOUS -> {
                   println("Today, smoking is going to save lives")
               }
               Situation.FORMAL -> {
                   println("Dwight Schrute, Assistant regional manager")
               }
               Situation.ANGRY -> {
                   println("Identity theft is not a joke Jim, Millions Families suffer every year!")
               }
   
               ...
              
           }
       }
   }
   ```

## Any Difference?
No!, Still the same.

Everytime there is certain situation is added, `existing code` should be modified.

This could still be error-prone, No help at all.


Both `inheritance and interface` of behaviors do not work. 


Are we tackling the exact problem? or What is the problem exactly??


## What is the problem, exactly?

Think about 2 previous cases: `Inheritance` and `Interface`

When we inherit or implement interface, the class utilizing it becomes `interface or super type`.

In 2 previous cases, class `Dwight` implemented `Character` or `Behavior`

As soon as Dwight implements one of them, the following becomes true:
```kotlin
   fun main() {

   val dwight = Dwight()
   println(dwight is Character)
   println(dwight is Behavior)
}
```
This is implementation(Dwight, Jim, Michael...) and `Character and Behavior` becomes `IS-A relationship`

Problem with IS-A relationship is it is not flexible, as you have noticed.






## Rethink current situation from the base

1. Character's attributes(methods, for right now) is changing, and likely to be changed in the future.
2. We need to keep things flexible
   - Open for extension, closed for modification(one of SOLID)
3. While keeping things flexible, We do not want to modify existing, or working code   
4. IS-A relation is not quite right when it comes to change 



## What's Next?

:point_right: [Solution](../solution)