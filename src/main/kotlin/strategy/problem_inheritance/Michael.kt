package strategy.problem_inheritance

class Michael : Character() {

    override fun move() {
        println("Happy walking")
    }

    override fun talk() {
        println("That's what she said")
    }
}