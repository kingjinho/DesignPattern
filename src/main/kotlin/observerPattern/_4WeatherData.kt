package observerPattern

import java.lang.IndexOutOfBoundsException

class _4WeatherData : _1Subject {
    private val observers by lazy { ArrayList<_2Observer>()}
    private var temperature = 0f
    private var humidity = 0f
    private var pressure = 0f

    override fun registerObserver(o: _2Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: _2Observer) {
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

    private fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }

}


