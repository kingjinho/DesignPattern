package observer

import java.util.*

class WeatherDataJava : Observable() {

    private var temperature = 0f
    private var humidity = 0f
    private var pressure = 0f

    private fun measurementsChanged() {
        setChanged()
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }

    fun getTemperature() = temperature
    fun getHumidity() = humidity
    fun getPressure() = pressure


}