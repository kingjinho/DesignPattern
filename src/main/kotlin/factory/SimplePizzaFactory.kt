package factory

class SimplePizzaFactory {
    fun createPizza(type: String) : Pizza {
        var pizza : Pizza? = null
        pizza = when (type) {
            "cheese" -> CheesePiazza()
            "pepperoni" -> PepperoniPizza()
            "clam" -> ClamPizza()
            "veggie" -> VeggiePizza()
            else -> SimplePizza()
        }
        return pizza
    }
}