package observer

import java.lang.IndexOutOfBoundsException

class WeatherData : Subject {
    private val observers by lazy { ArrayList<Observer>()}
    private var temperature = 0f
    private var humidity = 0f
    private var pressure = 0f

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
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


