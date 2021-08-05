# Strategy Pattern

### Brainstorming
1. Created a program that shows something
2. something inherits superclass
3. something needs additional features
4. change superclass -> thus change all subclasses (or make it default function)
5. `something goes wrong -> not all classes fit`

6. We take out of the part that could change, make it interface
7. subclass inherits superclass and implement interface based on specs
8. Duplicate code
9. If interface changes -> track down and changes all subclasses -> possibility of new bug

10. One constant in software development ->  `CHANGE`


11. `Take the parts that vary and encapsulate them, so that later you can alter or extend
the parts that vary without affecting those that don't`
    


