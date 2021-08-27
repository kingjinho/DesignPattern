package strategy.solution

fun main() {
    val dwight = Dwight(DwightAngry())
    dwight.setBehavior(DwightHappy())
    dwight.talk()

}