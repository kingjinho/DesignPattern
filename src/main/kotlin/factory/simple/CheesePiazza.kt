package factory.simple

class CheesePiazza : Pizza {

    override fun prepare() {
        println("Preparing cheese pizza")
    }

    override fun bake() {
        println("Baking cheese pizza")
    }

    override fun cut() {
        println("Cutting cheese pizza")
    }

    override fun box() {
        println("Packaging cheese pizza")
    }
}
