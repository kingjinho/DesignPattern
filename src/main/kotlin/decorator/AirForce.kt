package decorator

class AirForce : Shoe() {

    init {
        setDescription("Air Force")
    }

    override fun cost() = 30
}