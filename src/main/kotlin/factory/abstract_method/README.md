# Factory Pattern - Abstract Method

As you see from the simple factory pattern, Factory Pattern has 2 distinctive advantages.
1. Decoupling
    - Factory at Austin does not know exactly type of IPhone to manufacture (Polymorphism)
    - As long as we put correct parameter `manufatureSmartPhone(type: String)`, You can manufacture 
      literally any smartphone!
        - Using String as a parameter can cause problem. What if I typed 'GalaxyS21 Ultra'? (**enum for superpower!!**) 
2. **Only one place** where smartphone object creation occurs
    - There will be only one place you need to add or remove regarding IPhone object creation
    - One of OO principle states `closed for modification` **does not mean that you cannot or should not modify**


## Another Challenge    
So now, you are an owner of factory at Austin, and you decide to build another factory at Atlanta,GA.

You made a contract with Samsung and Atlanta will be the place where manufactures Samsung Galaxy series.

In this situation, along with your factory at Austin, How will you set up the process for Atlanta?
