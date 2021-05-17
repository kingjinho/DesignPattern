package adapterPattern

class DuckAdapter(private val duck: Duck) : Turkey {
    override fun gobble() {
        duck.quack()
    }

    override fun fly() {
        duck.fly()
    }
}