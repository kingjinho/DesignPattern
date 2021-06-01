package factory.simple

class SimplePizzaFactory {
    fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> CheesePiazza()
            "pepperoni" -> PepperoniPizza()
            "clam" -> ClamPizza()
            "veggie" -> VeggiePizza()
            else -> SimplePizza()
        }
    }
}