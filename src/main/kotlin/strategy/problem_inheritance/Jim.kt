package strategy.problem_inheritance

class Jim : Character() {

    override fun move() {
        println("normal walking")
    }

    override fun talk(situation: Situation) {
        when(situation) {
            //todo: speak based on situations
            //println("Hey, Dwight")
        }

    }
}