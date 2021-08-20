package strategy.problem_inheritance

class Toby: Character() {

    override fun move() {
        println("powerless walking")
    }

    override fun talk(situation: Situation) {
        when(situation) {
            //todo: speak based on situations
            //println("Toby, get out")
        }

    }
}