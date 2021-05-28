package factory

class PizzaStore(private val factory: SimplePizzaFactory) {

    fun orderPizza(type: String) {
        val pizza = factory.createPizza(type)
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
    }
}