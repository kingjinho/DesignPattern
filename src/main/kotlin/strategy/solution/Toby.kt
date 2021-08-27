package strategy.solution

class Toby : Character(), BehaviorTalk {

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