package strategy.solution

abstract class Character(private var behavior: SituationalBehavior?) {

    fun setBehavior(behavior: SituationalBehavior) {
        this.behavior = behavior
    }

    fun talk() {
        behavior?.talk()
    }

}