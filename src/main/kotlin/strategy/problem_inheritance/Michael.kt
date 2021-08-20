package strategy.problem_inheritance

class Michael : Character() {

    override fun move() {
        println("Happy walking")
    }

    override fun talk(situation: Situation) {
        when(situation) {
            //todo: speak based on situations
            //println("That's what she said")
        }
    }
}