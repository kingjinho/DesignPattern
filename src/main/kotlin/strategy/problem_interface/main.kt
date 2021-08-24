package strategy.problem_interface


fun main() {

    val dwight = Dwight()
    println(dwight is Character)
    println(dwight is Behavior)
}