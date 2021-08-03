# Abstract Factory

### Story
Let's think about how smartphone consists of.
1. It needs a battery,
2. It needs a RAM,
3. needs a Screen,
4. needs a CPU
5. needs a Camera, etc

However, When we think about various types of smartphones, They do not use exactly the same type.
Rather, They use similar but different components to assemble a smartphone.

Moreover, once components are defined, It cannot be changed throughout factories and one(Austin, Atlanta) cannot change 
components.

For IPhone, suppose it uses small battery, 4GB RAM, OLED screen, M1 CPU and A Camera to assemble.

For Galaxy, suppose it uses big battery, 6GB RAM, QLED screen, SnapDragon CPU and B camera to assemble.

They all have these as properties and needed when assembling, So we are going to instantiate these properties 
when calling `assemble( )`

In actual implementation we will implement `prepare( )` so that properties are instantiated properly.

How are we going to achieve that?

Since we assume that all Galaxy models use same components, as well as all IPhone models use same components,
we are going to `create a factory that creates appropriate properties for Glaxy and IPhone `

```kotlin
interface ComponentsFactory {

    fun createBattery() : Battery

    fun createRAM() : RAM

    fun createScreen() : Screen

    fun createCPU() : CPU

    fun createCamera() : Camera
}

```

While creating a factory class(or interface), It is also necessary to create property classes.  

```kotlin
//Galaxy
class GalaxyComponents : ComponentsFactory {
    override fun createBattery(): Battery  = BigBattery()

    override fun createRAM() = RAM_6GB()

    override fun createScreen() = QLED()

    override fun createCPU() = SnapDragon()

    override fun createCamera() = CameraB()
}

//IPhone
class IPhoneComponents: ComponentsFactory {

    override fun createBattery() = SmallBattery()

    override fun createRAM() = RAM_4GB()

    override fun createScreen() = OLED()

    override fun createCPU() = M1()

    override fun createCamera() = CameraA()
}
```

In this example, I could have let actual implementation class inherit `SmartPhone`, I just did not do it because 
just in case when IPhone and Galaxy have something different.

As stated above, We are going to instantiate properties when calling `assemble( )` and it does not and will not change,
I created a function called `prepare( )` and make it abstract, and have it called in `assemble( )` method

```kotlin
abstract class SmartPhone {
    var ram: RAM? = null
    var cpu: CPU? = null
    var camera: Camera? = null
    var battery: Battery? = null
    var screen: Screen? = null
    
        ...

    fun assemble() {
        prepare()
        println("Assembling Part")
    }

    ...
    
    
    abstract fun prepare()
    
}
```

So what now? our final job is to create instances of properties by overriding `prepare( )` and injecting
`componentsFactory` into both IPhone and Galaxy

```kotlin
//IPhone
abstract class IPhone(private val componentsFactory: ComponentsFactory) : SmartPhone() {

    override fun prepare() {
        cpu = componentsFactory.createCPU()
        screen = componentsFactory.createScreen()
        ram = componentsFactory.createRAM()
        camera = componentsFactory.createCamera()
        battery = componentsFactory.createBattery()
    }

}

//Galaxy
abstract class SamsungGalaxy(private val componentsFactory: ComponentsFactory) : SmartPhone() {

    override fun prepare() {
        cpu = componentsFactory.createCPU()
        screen = componentsFactory.createScreen()
        battery = componentsFactory.createBattery()
        ram = componentsFactory.createRAM()
        camera = componentsFactory.createCamera()
    }
}
```


One last thing!

When we think about where we create SmartPhone objects, it is done in `create( )` method in both Atlanta and Austin.

So We are going to create a proper instance of componentsFactory and pass it when creating actual smartphone instance
```kotlin
class Atlanta : Factory() {

    override fun create(type: EType): SmartPhone {
        val componentsFactory = GalaxyComponents()
        return when(type) {
            EType.GALAXY_S9 -> SamsungGalaxyS9(componentsFactory)
            EType.GALAXY_S10 -> SamsungGalaxyS10(componentsFactory)
            EType.GALAXY_S20 -> SamsungGalaxyS20(componentsFactory)
            EType.GALAXY_S21 -> SamsungGalaxyS21(componentsFactory)
            else -> SamsungGalaxyS8(componentsFactory)
        }
    }
}

class Austin : Factory() {

    override fun create(type: EType): SmartPhone {
        val componentsFactory = IPhoneComponents()
        return when (type) {
            EType.IPHONE_10 -> IPhone10(componentsFactory)
            EType.IPHONE_11 -> IPhone11(componentsFactory)
            EType.IPHONE_12 -> IPhone12(componentsFactory)
            EType.IPHONE_SE -> IPhoneSE(componentsFactory)
            else -> IPhone9(componentsFactory)
        }
    }
}
```

## What is Abstract Factory?

1. Provides an interface for a families of related or dependent objects without specifying their concrete classes
2. Decouples from actual products


## Factory method vs Abstract Factory

1. Something in common
- Create objects by decoupling code from client
- Encapsulate object creation to keep loose coupling
- Code to abstractions  
- Reduce dependency 

    
2. Factory Method
- Create objects through inheritance(extend a class and override a factory method)
- Use subclass to do object creation(`one object`)
- Client does `only need to know abstract type`, whereas subclass cares about its implementation
- Allow class to defer instantiation to its subclasses


3. Abstract Factory
- Create objects through composition
- Abstract type for creating a `family of products`
- Instantiate one and pass it as a parameter
- Often implemented as Factory Method
- Create related objects without having to depend on concrete classes  
- `If one or more products are added to an interface,`
    - `Need to change an interface(change every subclass)`
    
     

