package observerPattern

class _6HeatIndexDisplay(weatherData: _4WeatherData) : _2Observer, _3DisplayElement {
    private var temp = 0f
    private var humidity = 0f
    private var pressure = 0f
    private var heatIndex = 0f


    init {
        weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temp = temp
        this.humidity = humidity
        this.pressure = pressure
        this.heatIndex = calculateHeatIndex(temp, humidity)
        display()
    }

    override fun display() {
        println("Heat index is $heatIndex")
    }

    private fun calculateHeatIndex(t: Float = temp, rh: Float = humidity): Float {
        return ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh))).toFloat()
    }
}