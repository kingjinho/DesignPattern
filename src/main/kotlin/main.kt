import observerPattern._4WeatherData
import observerPattern._5CurrentConditionsDisplay
import observerPattern._6HeatIndexDisplay

fun main(args: Array<String>) {
    val weatherData = _4WeatherData()
    var currentDisplay = _5CurrentConditionsDisplay(weatherData)
    var heatIndexDisplay = _6HeatIndexDisplay(weatherData)

    weatherData.setMeasurements(80f, 65f, 30.4f )
    weatherData.setMeasurements(82f, 70f, 29.2f )
    weatherData.setMeasurements(78f, 90f, 29.2f )
}