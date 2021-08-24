# Problem with inheritance

## Case

Ok, We as a game developer team released game successfully.

Whenever I talk to one of characters, `talk( )` functions will be triggered.

This fits the initial plan. Whenever characters talk, it will trigger `talk( )`.

Later, Boss comes into our team saying

> Boss: Hey, our game is great,
> 
> How did you come up with putting the Office characters into our game? Incredible!! 
> 
> as you know, Our characters only speak their most famous quotes. I'm very much satisfied, but 
> 
> people want just more than that. like Michael says 'That's what she said' in awkward situation,
> 
> Jim speaks 'Bear, Beets. Battlestar Galactica' in serious situation.
> 
> Yeah, speak famous quotes based on situations. Can you do that?


## Point

Yes, `Change` has occurred.

It seems like there's `no other way except changing existing working code` to reflect needs

So this is your modification.

1. Added parameter in `talk( )` method to identify situation.
``` kotlin
abstract class Character {

    abstract fun move()

    abstract fun talk(situation: Situation)
}
```


2. Change whatever classes that inherits :point_right: Michael, Jim, Dwight and Toby. 
```kotlin
class Dwight : Character() {

    override fun move() {
        println("Walking with confidence")
    }

    override fun talk(situation: Situation) {
        ...
    }
}
```

3. Modify `talk(situation: Situation)` behavior accordingly
```kotlin
class Dwight : Character() {

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

(Jim, Michael, Toby are not implemented as Dwight, They are there for illustration)


## Takeaways
- Inherit from supertype may lead to following problems:
    1. Once there are changes in supertype, `All implementations have to be reviewed and modified`
        - In this case, I have to modify Dwight, Jim, Michael and Toby. What if more than 
          4 Characters?
        - What if more situations are added, or more parameters are added?
    2. I have changed working code! It may work without bugs, but `with a high probability, 
       Changes in working code will produce unexpected errors!`

       
- It turns out that inheritance is not the right answer for this.
    - Abstracting out common behavior in supertype is right, but not quite right when it comes to
    maintenance
      


#### What about interface? Could this be a better solution?      




## Next
:point_right: [Problem with interface](../problem_interface)




