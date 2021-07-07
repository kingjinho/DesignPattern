package observer

import java.util.*
import java.util.Observer

class ForecastDisplayJava(private val observable: WeatherDataJava) : Observer, DisplayElement {

    private var currentPressure = 29.92f
    private var lastPressure = 0f


    init {
        observable.addObserver(this)
    }

    override fun update(o: Observable?, arg: Any?) {
        if (o is WeatherDataJava) {
            o.let {
                this.lastPressure = currentPressure
                this.currentPressure = it.getPressure()
                display()
            }
        }
    }

    override fun display() {
        println("last pressure: $lastPressure, current pressure: $currentPressure")
    }
}