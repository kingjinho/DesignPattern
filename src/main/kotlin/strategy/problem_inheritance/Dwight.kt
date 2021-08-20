package strategy.problem_inheritance

class Dwight : Character() {

    override fun move() {
        println("Walking with confidence")
    }

    override fun talk(situation: Situation) {
        when(situation) {
            Situation.AWKWARD -> {

            }
            Situation.FUNNY -> {

            }
            Situation.SAD -> {

            }
            Situation.SERIOUS -> {
                println("Today, smoking is going to save lives")
            }
            Situation.FORMAL -> {
                println("Dwight Schrute, Assistant regional manager")
            }
            Situation.ANGRY -> {
                println("Identity theft is not a joke Jim, Millions Families suffer every year!")
            }
        }
    }
}