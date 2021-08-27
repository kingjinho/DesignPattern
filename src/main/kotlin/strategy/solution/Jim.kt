package strategy.solution

class Jim : Character(), BehaviorTalk {

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