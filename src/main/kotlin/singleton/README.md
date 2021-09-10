# Singleton

# What is Singleton?

> Don't you hear me what I say? I am the only one, no matter what!!!

- An object creation pattern that helps to contain only one instance throughout software lifecycle.

# Key Points

1. Create only one object for the first time and return it everytime it is needed
2. Provide global access point to that instance

# Why Singleton Pattern?

1. By using Singleton pattern, Applications can keep certain object that has to be only one, 
   prevent applications from instantiating here and there
2. It also provides one way to retrieve an object, like Global variable

# Why not using Global variable?

- Problems with using global variable arise in cases like
    1. What if we do not use it?
    2. Why do we have to instantiate an object as soon as applications start?
    3. What if we mistakenly set it as mutable?
    4. Lazy initialization
    5. Cannot keep only one instance

# Where it is used?

- Reading & Writing database(Android RoomDatabase Instances)or a file
- Caches, Thread pools
- Or some shared resources

# How it is achieved?

1. Create a default constructor which contains private access modifier
    - Class outside cannot instantiate
2. Create an empty static variable that represents & a static method that invokes private constructor
3. When static method gets called, check whether static variable is empty or not
4. If empty, invoke private constructor and assign it to static variable
5. Return object already created

# Code Implementation
```kotlin
class ChocolateBoiler private constructor() {
   
   /**
    * private constructor, No one can instantiate this class
    * getInstance() only way to get(ask) instantiated class
    */
   
    companion object {
        private var INSTANCE: ChocolateBoiler? = null
        fun getInstance(): ChocolateBoiler {
            if (INSTANCE == null) {
                INSTANCE = ChocolateBoiler()
            }
            return INSTANCE!!
        }
    }

    //some other method

}
```

# In different threads?
- Code above looks fine, when it comes to a single thread.
- If your application uses more than one thread, This could lead to multiple instances


# Solution when it comes to multithreading?
- Make use of synchronized in static function
   - By using it, We force every thread to wait its turn
   ```kotlin
    companion object {
        private var INSTANCE: ChocolateBoiler? = null
        fun getInstance(): ChocolateBoiler {
            return INSTANCE ?: synchronized(this) {
                val instance = ChocolateBoiler()
                INSTANCE = instance
                instance
            }
        }
    }
   ```

# Being forced to wait, We get it, but isn't synchronization expensive?
- It is, but synchronization only matters in first time the method creates an instance 

### Other options instead of synchronization while keeping thread-safe?
1. Do nothing if performance of `getInstance()` isn't that critical

2. Create an instance eagerly rather than lazy
    ```kotlin
    companion object {
        private val INSTANCE = ChocolateBoiler()
        fun getInstance(): ChocolateBoiler {
            return INSTANCE
        }
    }
    ```

3. Double-checked locking 
    - Check to see if instance is created
    - If not, then synchronize
    
    - Still synchronize when it is first time
    ```kotlin
    companion object {
    @Volatile
    private var INSTANCE: ChocolateBoiler? = null
    
            fun getInstance(): ChocolateBoiler {
                return INSTANCE ?: synchronized(this) {
                    val instance = ChocolateBoiler()
                    INSTANCE = instance
                    instance
                }
            }
        }    
    ```
    - Volatile keyword ensures that write to this field are immediately visible to other threads
    


# Cons..?
- Do more than one thing(violates `Single Responsibility`)
    - Managing only one instance
    - Its main role

# Links, References

[Singleton](https://refactoring.guru/design-patterns/singleton)

Head First Design Pattern - The Singleton Pattern