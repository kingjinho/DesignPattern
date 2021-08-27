package strategy.solution

class DwightAngry: SituationalBehavior {
    override fun move() {
        println("Running")
    }

    override fun talk() {
        println("Michael!!!")
    }
}