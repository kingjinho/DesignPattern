package adapter


/**
 * Duck: the interface of the type adapting to (interface that client expects to see)
 * turkey: object that we are adapting
 */
class TurkeyAdapter(private val turkey: Turkey) : Duck {

    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        for(i in 0..4) {
            turkey.fly()
        }
    }
}