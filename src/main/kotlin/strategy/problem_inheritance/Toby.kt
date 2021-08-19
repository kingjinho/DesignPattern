package strategy.problem_inheritance

class Toby: Character() {

    override fun move() {
        println("powerless walking")
    }

    override fun talk() {
        println("Toby, get out")
    }
}