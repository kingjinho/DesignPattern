# Solution 2 - Better one
Remember when we first created our simple factory pattern(not pattern exactly, though), We discussed one OO design principle
> OO Design Principle : Identify what varies

The only thing that varies is object creation, not others.

In our example, manufacturing a smartphone, We want to keep the process resides in `manufacturingSmartPhone( )` method, as well as having flexibility of object creation.

Is there a way to meet our needs?

Throughout previous examples (if you start reading from simple package, hopefully :smile: ), a characteristic that those examples have is
> Create a class(factory class) that is solely dedicated to object creation 

However, this does not ensure our process, or this does not guarantee that we make an error by mistake

What if, What if we `delegate object creation to actual class?`(in our case, Atlanta factory, Austin factory) while `letting the super class handle process?`, which means,
>Localizing manufacturing activity to Factory (Austin, Atlanta in our case)

Let's see what that means through code


## Solution
1. Create an abstract class that has methods called `manufactureSmartPhone(type: EType)` and `create(type: EType)`
2. `manufactureSmartPhone(type: EType)` works as we saw in previous examples
    - receive SmartPhone object from `create(type: EType)`, and proceed further
```kotlin
abstract class Factory {

    fun manufactureSmartPhone(type: EType) : SmartPhone{
        val phone = create(type)

        phone.assemble()
        phone.testVoiceCall()
        phone.testTextMessaging()
        phone.testWifi()
        phone.testInternetConnection()

        return phone
    }

    abstract fun create(type: EType) : SmartPhone
}
```
3. In `manufactureSmartPhone(type: EType)`, it still does not know the actual implementation(polymorphism)
4. Open Both Atlanta and Austin class and inherit `Factory` class
5. Remove `manufacturSmartPhone(type: EType)` method that we had written previously
6. Override `create(type: EType)` method
```kotlin
class Atlanta : Factory() {

    override fun create(type: EType): SmartPhone {
        return when(type) {
            EType.GALAXY_S9 -> SamsungGalaxyS9()
            EType.GALAXY_S10 -> SamsungGalaxyS10()
            EType.GALAXY_S20 -> SamsungGalaxyS20()
            EType.GALAXY_S21 -> SamsungGalaxyS21()
            else -> SamsungGalaxyS8()
        }
    }
}
```

```kotlin
main.kt
val austin: Factory = Austin()
austin.manufactureSmartPhone(EType.IPHONE_12)

val atlanta : Factory = Atlanta()
atlanta.manufactureSmartPhone(EType.GALAXY_S9)
```
**Object creation has been moved into a method that acts as a factory**

## Achievement
Throughout modification this is what we got so far:
1. `We still separate and encalcupate object creation(what varies) from the things that do not change`
2. `manufactureSmartPhone(type:EType)` as no idea the actual smartphone: `Decoupled`
3. `We ensure that all factory(Austin, Atlanta, for now) follow same procedure of manufacturing a smartphone(things that do not change)` 

# Factory method pattern
>I(Factory::class) do not decide what to create, my children(subclass: Austin::class, Atlanta::class) decide what object they will create

`Defines an interface for creating an object, let subclasses decide what to instantiate`
1. **Encapsulate object creation by letting subclasses decide**
2. This pattern is useful when making object creation as `framework`
      - ensure process
      - object creation based on variations (is it an IPhone or Galaxy) and separate it based on variations         
         - Done at actual implementation classes (Factory at Austin and Atlanta)    
      - super class(Factory) knows its process, but it does not know the actual implementation
         - subclass decided what to create (`Decoupled`)
         - `method at actual implementation now works as a factory`
3. Let subclass `decide`?
   - Not because the pattern allows subclasses to decide at runtime, but
   - because the creator(Factory) is written without knowledge of actual products(SmartPhone)
      - decided by the choice of the subclass that is used
4. While Factory class produces abstract class(Smartphone), its implementation produces implementation of abstract class(IPhone, Galaxy)
   - SmartPhone : (Abstract) Product
   - Factory: (Abstract) Creator
   - IPhone and Galaxy : Actual Product
   - Austin and Atlanta : Actual Creator
   - this relationship is known as `parallel class hierarchies`
   

# Time to talk about dependency...
Think about when we create object without factory pattern
```kotlin
fun manufactureSmartPhone(type: String): SmartPhone {
        val phone = when (type) {
            "IPhone10" -> IPhone10()
            "IPhone11" -> IPhone11()
            "IPhone12" -> IPhone12()
            "IPhoneSE" -> IPhoneSE()
            "IPhoneSE2" -> IPhoneSE2()
              ...
              "IPhone40" -> IPhone40()
            "GalaxyS8" -> SamsungGalaxyS8()
            "GalaxyS9" -> SamsungGalaxyS9()
            "GalaxyS10" -> SamsungGalaxyS10()
            "GalaxyS20" -> SamsungGalaxyS20()
            "GalaxyS21" -> SamsungGalaxyS21()
              ...
            "GalaxyS45" -> SamsungGalaxyS45()
            else -> IPhone9()
        }

        phone.assemble()
        phone.testInternetConnection()
        phone.testWifi()
        phone.testVoiceCall()
        phone.testTextMessaging()

        println("All Test Passed!")

        return phone
    }
```
If we `instantiate an object directly on client code`, then the client code `will depend on that object`
This means,
1. Any changes to object may lead us to modify our client code(adding, removing)
2. `Every new object is added` to our client code, it eventually `creates another dependency`

Thus, it is clear that `reducing dependency gives us more room of flexibility`.

Yes, this is so-called `Dependency Inversion Principle` from OO design principle.

> Depend upon abstractions, not on implementations 

It is similar to phrase `Program to an interface not an implementation`, but `Dependency Inversion Principle` has rigid stance
toward abstraction:

> 1. High-level components should not depend on our low-level components; They should both depend on abstractions
> 
> 
> 2. Abstraction should not depend on details, details should depend on abstraction


### High-level component? Low-level component?
High-level component : Factory

Low-level component : SmartPhone

If we look at the code above, we notice that it is very dependent on implementations, not abstraction.

To solve this issue, We used `Factory method pattern` to resolve very dependent situation.
1. We create an `abstract high-level component`(Factory, in our case), and `this class depends on abstract low-level component(SmartPhone)`
2. From low-level component perspective, `actual implementation also depends on low-level component`.
3. Thus, Both high and low-level component depend on abstraction, SmartPhone

### Dependency Inversion Principle, So We've covered dependency, what about Inversion????
>Inversion : Reverse, Opposite
> 
> Inverse what? Your way of thinking about OO design

Please take a moment to think about how your thought process went through when reading my post

Here is what I had gone through when writing example code
1. First, I need a Factory class because I will be talking about factory pattern
2. Second, I need to come up with product that Factory can manufacture, Something Fresh, cool and familiar... Smartphone boom! :facepunch:

