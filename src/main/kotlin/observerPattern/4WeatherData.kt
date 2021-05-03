package observerPattern

import java.lang.IndexOutOfBoundsException

class `4WeatherData` : `1Subject` {
    private val observers by lazy { ArrayList<`2Observer`>()}
    private var temperature = 0f
    private var humidity = 0f
    private var pressure = 0f

    override fun registerObserver(o: `2Observer`) {
        observers.add(o)
    }

    override fun removeObserver(o: `2Observer`) {
        if(observers.indexOf(o) < 0) {
            throw IndexOutOfBoundsException()
        }
        observers.remove(o)
    }

    /**
     * where we tell the observers about the state
     * since they are all observers, we know they all implement update()
     */
    override fun notifyObservers() {
        for(observer in observers) {
            observer.update(temperature, humidity, pressure)
        }
    }

    fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }

}


