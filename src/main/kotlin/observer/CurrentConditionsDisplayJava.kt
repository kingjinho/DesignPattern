package observer

import java.util.*

class CurrentConditionsDisplayJava(private val observable: Observable) : Observer, DisplayElement {

    private var temperature = 0f
    private var humidity = 0f

    init {
        observable.addObserver(this)
    }

    override fun update(o: Observable?, arg: Any?) {
        if(o is WeatherDataJava) {
            o.let {
                this.temperature = it.getTemperature()
                this.humidity = it.getHumidity()
                display()
            }
        }
    }

    override fun display() {
        println("Current Conditions: ${temperature}F degrees and ${humidity}% humidity")
    }
}