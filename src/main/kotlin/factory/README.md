# Factory Pattern

- Q: What is it that trying to solve?
- A: Factory pattern is a design pattern that `decouples class instantiation from the client`.

There is nothing wrong with instantiating a class in the client code, and you will have to do it anyway when developing
 an application. However, when you need an object that is likely to differ based on conditions, creating the instance
from client code might cause strongly coupled relationship.

## Case
Suppose you write an application for machine that manufactures various types of IPhones and Samsung Galaxy.

The machine assembles parts to produce smartphones and all your workers to do is to press buttons saying '
IPhone11', 'IPhone12', 'IPhone SE', etc and these buttons will trigger the following code.

```kotlin
//factory located at Texas Austin
class FactoryAtTexasAustin {

    fun manufactureSmartPhone(type: String): SmartPhone {
        val phone = when (type) {
            "IPhone10" -> IPhone10()
            "IPhone11" -> IPhone11()
            "IPhone12" -> IPhone12()
            "IPhoneSE" -> IPhoneSE()
            "IPhoneSE2" -> IPhoneSE2()
            "GalaxyS8" -> SamsungGalaxyS8()
            "GalaxyS9" -> SamsungGalaxyS9()
            "GalaxyS10" -> SamsungGalaxyS10()
            "GalaxyS20" -> SamsungGalaxyS20()
            "GalaxyS21" -> SamsungGalaxyS21()
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
}

```

A year later, You make a new contract with both Apple and Samsung regarding manufacturing new smartphone, IPhone12 and
SamsungGalaxyS21. So you add few more lines of code to reflect changes.

```kotlin
class FactoryAtTexasAustin {

    fun manufactureSmartPhone(type: String): SmartPhone {
        val phone = when (type) {
            "IPhone10" -> IPhone10()
            "IPhone11" -> IPhone11()
            "IPhone12" -> IPhone12()
            "IPhoneSE" -> IPhoneSE()
            "IPhoneSE2" -> IPhoneSE2()
            "GalaxyS8" -> SamsungGalaxyS8()
            "GalaxyS9" -> SamsungGalaxyS9()
            "GalaxyS10" -> SamsungGalaxyS10()
            "GalaxyS20" -> SamsungGalaxyS20()
            "GalaxyS21" -> SamsungGalaxyS21()
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
}
```
As year goes by, your factory at Texas Austin manufactures new smartphones, you will keep changing code like below
```kotlin
class FactoryAtTexasAustin {

    fun manufactureSmartPhone(type: String, color: String): SmartPhone {
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
}
```
What do you think about this code?

You may feel like there's nothing wrong with code.

If you feel like there is nothing wrong with this code, then I have questions for you.

1. Why do you think `manufactureSmartPhone()` knows exact type of smartphone?
2. What if you have to remove some types of smartphones or add smartphone?
3. What if smartphone object creation occurs on other part of your code?



## Twist 1

