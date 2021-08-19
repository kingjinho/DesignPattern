package strategy.problem_inheritance

class Jim : Character() {

    override fun move() {
        println("normal walking")
    }

    override fun talk() {
        println("Hey, Dwight")
    }
}