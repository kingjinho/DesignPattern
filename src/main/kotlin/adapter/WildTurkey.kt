package adapter

class WildTurkey : Turkey {
    override fun gobble() {
        println("gobble")
    }

    override fun fly() {
        println("I'm flying a short distance")
    }
}