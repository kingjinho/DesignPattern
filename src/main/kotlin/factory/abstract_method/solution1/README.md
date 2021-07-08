# Solution 1

## Situation
1. Build another factory for Samsung Galaxy series
2. It is smartphone, and we already have SmartPhoneFactory


## Solution
1. Change SmartPhoneFactory once class in simple package into interface
    - You can still proceed without it
2. Create a factory class for Samsung Galaxy, which implements SmartPhoneFactory interface
3. Override `create( )` method.
4. Create a class called Atlanta and composite it with SmartPhoneFactory
```kotlin
class Atlanta(private val factory: SmartPhoneFactory) {
    ...
}
```
5. On main.kt,
```kotlin
fun main(args: Array<String>) {
    val austin = Austin(IPhoneFactory())
    austin.manufactureSmartPhone("IPhone9")

    val atlanta = Atlanta(GalaxyFactory())
    atlanta.manufactureSmartPhone("Galaxy9")
}
```

## Story Continues...
You hired thousands of workers for Atlanta. What Atlanta is different from workers at Austin is that Atlanta workers are genius.

They are smartphone genius so that they test network connection right after assembling because they think it is more efficient.

No, no, no 

That is not what you want. The only thing that varies is whether it is an IPhone or Samsung Galaxy, not the steps after.

You cannot skip any of these procedures due to quality control.


## Points from story
Take a look at code.
I slightly changed the process of manufacturing smartphones
```kotlin
class Atlanta(private val factory: SmartPhoneFactory) {

    fun manufactureSmartPhone(type: String): SmartPhone {
        val phone = factory.create(type)

        phone.assemble()
        phone.testVoiceCall()
        phone.testTextMessaging()
        phone.testWifi()
        phone.testInternetConnection()

        println("All Test Passed!")

        return phone
    }
}

class Austin(private val factory: SmartPhoneFactory) {

   fun manufactureSmartPhone(type: String): SmartPhone {
      val phone = factory.create(type)

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
Actually, in programming, changes is test order will happen because we as a programmer, because you not only cares about this, but also thinks about other side as well.

Yes, error-prone. What if `testVoideCall()` and `testTextMessaging()` can have implicit impact on network test, thus must be performed beforehand? 

Test will fail, and you will get an error.

Since example above is a simplified version of real world application, it seems like no impact on each test.

However, If it is a real world situation, and you as a junior developer failed to do that, then Oh my lord...


## So what? 
We need a system that has control over process unless stated.
SmartPhone should be tested following order: voice, text and network(wi-fi, internet)

Move on to Solution2! :point_right: