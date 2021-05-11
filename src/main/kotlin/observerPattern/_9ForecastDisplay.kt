package observerPattern

import java.util.*

class _9ForecastDisplay(private val observable: _7WeatherDataJava) : Observer, _3DisplayElement {

    private var currentPressure = 29.92f
    private var lastPressure = 0f


    init {
        observable.addObserver(this)
    }

    override fun update(o: Observable?, arg: Any?) {
        if (o is _7WeatherDataJava) {
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