package strategy.problem_inheritance

class Dwight : Character() {

    override fun move() {
        println("Walking with confidence")
    }

    override fun talk() {
        println("Dwight Schrute, Assistant regional manager, Michael, Michael!!")
    }
}