
# Design Pattern


## Abstract

The first design pattern that I encountered was Adapter Pattern which frequently used in developing android
applications. When I first saw it, it was not only hard to read, but also it made me think "Why does this have to be
done this way?"

For example, let's talk about `creating an object` as an example to see what we can observe.

```kotlin
class FactoryAtTexasAustin {

    fun manufactureSmartPhone(type: String): SmartPhone {
        val phone = when (type) {
            "IPhone10" -> IPhone10()
            "IPhone11" -> IPhone11()
            "GalaxyS8" -> SamsungGalaxyS8()
            "GalaxyS9" -> SamsungGalaxyS9()
            "GalaxyS10" -> SamsungGalaxyS10()
            "GalaxyS20" -> SamsungGalaxyS20()
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

Suppose `the code above` represents button in machine that manufactures
smartphones based on types that they want, and `was your initial version`

What do you think about this
code? `Nothing wrong! because the way we create object is done by using object's constructor.`

A year later, the machine starts adding more types of smartphones, and you as a software developer needs to reflect
changes.

After changes, your code will look something like this:

```kotlin
class FactoryAtTexasAustin {

    fun manufactureSmartPhone(type: String, color: String): SmartPhone {
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

        //Assume the both smartphone follows 
        //the same process of assembling and testing 
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

As years goes by, you keep maintaining code as you have done in the previous, and your code will end up like this:

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
                "IPhone40"
            -> IPhone40()
            "GalaxyS8" -> SamsungGalaxyS8()
            "GalaxyS9" -> SamsungGalaxyS9()
            "GalaxyS10" -> SamsungGalaxyS10()
            "GalaxyS20" -> SamsungGalaxyS20()
            "GalaxyS21" -> SamsungGalaxyS21()
                ...
                "GalaxyS45"
            -> SamsungGalaxyS45()
            else -> IPhone9()
        }

        //Assume the both smartphone follows 
        //the same process of assembling and testing
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

Still, there seem to be nothing wrong with the code.

However, Both Samsung and Apple announced that the way assemble and test for both IPhone and GalaxyS is going to be different from now on.

What would you do?

```kotlin
class FactoryAtTexasAustin {

    fun manufactureSmartPhone(type: String, color: String): SmartPhone {
        val phone = when (type) {
                ...
        }

        if (phone is IPhone) {
            //test related work
            ...
        } else if (phone is SamsungGalaxy) {
            //test related work
            ...
        }

        println("All Test Passed!")

        return phone
    }
}
```

Really the last thing, `if assembling and testing procedures are more segmented`,

what would you do?  Maybe, like this?
```kotlin
class FactoryAtTexasAustin {

    fun manufactureSmartPhone(type: String, color: String): SmartPhone {
        val phone = when (type) {
                ...
        }

        if (phone is IPhone) {
            if (phone is IPhone10) {
                ...
            } else if (phone is IPhone11) {
                ...
            } else if (phone is IPhone12) {
                ...
            }
                ...
            
        } else if (phone is SamsungGalaxy) {
            if (phone is SamsungGalaxyS8) {
                ...
            } else if (phone is SamsungGalaxyS9) {
                ...
            } else if (phone is SamsungGalaxyS10) {
                ...
            }
                ...
        }

        println("All Test Passed!")

        return phone
    }
}
```

## Thoughts on the case
Do feel somewhat overwhelming through example?

Do you think that method `manufactureSmartPhone()` has a lot going on?

Throughout my experience, there were no such projects or applications that stays the same.

Yes, It `changes` as soon as you finish up writing you application, the next process is most likely be `maintenance`

During the `maintenance`, the following might(sure it will) happen to you.

- Some changes request from client may not fit in the initial application design at all.

    -  `Client: Can you fix this and this?`

    - `Me after inspection: Can't do this right now, because that does not fit into our original design`

- When you reflect changes you might think,

    - `Ok, It is simple one, All I need to do is to change classA, classB.`

    - `Oh, since class B,C,D inherits classA and B, these needs to be fixed.`

    - `Oh, one more thing! since class E,F,G,H are variables of classA and classB, these classes are should be modified.`

    - `And let me see...Oh Come on!!! class A and B are also variables of class L,M,N,O,P`

- When working with colleagues

    - `Brent: Hey, I cannot really understand the code you had written, so as Jenny.`

    - `Me: (in my brain) I thought I clearly write it, What is wrong with you all?`

- The more horrible part is that any changes you made in your application may result in consequences

    - `Boss: Hey, The changes that you made last week has serious flaws. it is supposed to manufactures IPhone11, not IPhone12!!!!!!`

    - `Me: ???`

So far, We've noticed a few things
1. **Application changes overtime**
2. As your application changes overtime, and you reflect it, it is plausible that some features you initially made or changes you going to make
   will not fit into your application
3. Sometimes, knowing OO basic design principles is not enough
4. Things from 1-3 are **DISCOVERED OVERTIME**
5. This is where design pattern comes in


## Conclusion: What is Design Pattern?
**Design pattern is a rule of thumb, or formalized best practices of dealing with commonly occurring problems within software design.**

Commonly occurring problems can be
1. Code re-usability
2. Code flexibility
3. Maintenance issues



## Content

1. Strategy
2. Observer
3. Adapter
4. Facade
5. Factory