# Singleton


# What is Singleton?
> Don't you hear me what I say? I am the only one, no matter what!!!

- An object creation pattern that helps to contain only one instance throughout software lifecycle.

# Key Points
1. Create only one object for the first time and return it everytime it is needed
2. Provide global access point to that instance


# Why Singleton Pattern?
1. By using Single


# Why not using Global variable?
- Problem with using global variable

# Where it is used?
- Reading & Writing database(Android RoomDatabase Instances) or a file
- Caches, Thread pools  
- Or some shared resources


# How it is achieved?
1. Create a default constructor which contains private access modifier
    - Class outside cannot instantiate
2. Create an empty static variable that represents & a static method that invokes
  private constructor
3. When static method gets called, check whether static variable is empty or not
4. If empty, invoke private constructor and assign it to static variable
5. Return object already created

# Code Implementation



# In different threads?



# Pros and Cons


# Links, References
[Singleton](https://refactoring.guru/design-patterns/singleton)

Head First Design Pattern - The Singleton Pattern