package observerPattern

class `5CurrentConditionsDisplay`(weatherData: `1Subject`) : `3DisplayElement`, `2Observer` {

    private var temperature = 0f
    private var humidity = 0f
    private var weatherData : `1Subject`? = weatherData

    init {
        weatherData.registerObserver(this)
    }

    override fun display() {
        TODO("Not yet implemented")
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        TODO("Not yet implemented")
    }
}