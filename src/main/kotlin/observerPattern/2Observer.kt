package observerPattern

interface `2Observer` {
    /**
     * temp, humidity, pressure: values from Subject
     * all observers must implement this inferface
     */


    fun update(temp: Float, humidity: Float, pressure: Float)
}