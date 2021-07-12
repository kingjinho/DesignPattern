# Solution 2 - Better one
Remember when we first created our simple factory pattern(not pattern exactly, though), We discussed one OO design principle
> OO Design Principle : Identify what varies

The only thing that varies is object creation, not others.

In our example, manufacturing a smartphone, We want to keep the process inside the `manufacturingSmartPhone( )` method, as well as having flexibility of object creation.

Is there a way to meet our needs?

Throughout previous examples (if you start reading from simple package, hopefully :smile: ), a characteristic that those examples have is
> Create a class(factory class) that is solely dedicated to object creation 

However, this does not ensure our process, or this does not guarantee that we make an error by mistake

What if, What if we `delegate object creation to actual class?`(in our case, Atlanta factory, Austin factory) while `letting the super class of
actual class handle process?`, which means,
>Localizing manufacturing activity to Factory (Austin, Atlanta in our case)

Let's see what that means through code


# Solution
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
2. While Factory class produces abstract class(Smartphone), its implementation produces implementation of abstract class(IPhone, Galaxy)
   - SmartPhone : (Abstract) Product
   - Factory: (Abstract) Creator
   - IPhone and Galaxy : Actual Product
   - Austin and Atlanta : Actual Creator
   


