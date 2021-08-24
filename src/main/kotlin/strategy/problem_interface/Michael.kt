package strategy.problem_interface

class Michael : Character(), Behavior {

    override fun move() {
        println("Happy walking")
    }

    override fun talk(situation: Situation) {
        when (situation) {
            //todo: speak based on situations
            //println("That's what she said")
        }
    }
}