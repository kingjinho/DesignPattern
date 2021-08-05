
# Design Pattern


## Abstract

The first design pattern that I encountered was Adapter Pattern which frequently used in developing android
applications. When I first saw it, it was not only hard to read and understand, 
but also it made me think "Why does this have to be done this way?"

Before we get into what is design pattern, 
let's talk about a real world case which is most likely to occur in your life.


## Beginning of Story
Suppose your project was to write an application that is shipped into a machine that manufactures various types of
smartphones.

Based on specifications and client's needs, you write an application with no errors, What a genius!

Your job in this project was to write some code, which is triggered by button press. When a worker presses a button,
Machine will assemble parts, test and dispense smartphone.

`the code below` represents button in machine that manufactures
smartphones based on types that they want, and `was your initial and final version`.

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

What do you think about this
code? `Seems like there nothing wrong in this case. Let's see...`
 

## Story Continues... - Change
So far so good! because client haven't filed any issues, and your part has been working seamlessly.

However, a year after,
the factory starts adding more types of smartphones, client wants to add reflect it.

You as a software developer needs to keep up with changes.

After some modification, your code looks something like this:

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
Still, it works fine and no errors are filed.

## Story continues... - Change on change

As years goes by, new types of phones are added as client business prospers,

And you keep maintaining code as you have done in the previous, and your code ends up like this:

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

Still, there seem to be nothing wrong with the code even though your code starts looking somewhat not right. 


## The Last - Change on change on change
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
Ok, it works fine with no errors even though it gets messier as you reflect changes... 


## Final Twist
Really the last thing, `What if assembling and testing procedures are more segmented?`

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
**Do you think this is the best way you would keep up with changes overtime?**


## Thoughts on the case
What do you think about the case above?

It may seem exaggerated, or too extreme, but I am sure you have encountered similar situation at least once.

Do feel somewhat overwhelming through example?

Do you think that method `manufactureSmartPhone()` has a lot going on?

Throughout my experience, there were no such projects or applications that stays the same.

Yes, It `changes` as soon as you finish up writing you application, the next process is most likely be `maintenance`

During the `maintenance`, the following might(sure it will) happen to you.

- Changes requested from client may not fit in the initial application design at all.
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
    - `Brent: (after 10 minutes of listening my explanation) To put it simply, Observer Pattern right?`

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

Commonly occurring problems can be, or is helpful for
1. Code re-usability
2. Code flexibility
3. Maintenance issues



## Content

1. [Strategy](src/main/kotlin/strategy)
2. Observer
3. Adapter
4. Facade
5. Factory