package strategy.problem_interface

class Toby : Character(), Behavior {

    override fun move() {
        println("powerless walking")
    }

    override fun talk(situation: Situation) {
        when (situation) {
            //todo: speak based on situations
            //println("Toby, get out")
        }

    }
}