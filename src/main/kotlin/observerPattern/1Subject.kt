package observerPattern

interface `1Subject` {
    fun registerObserver(o: `2Observer`)
    fun removeObserver(o: `2Observer`)
    fun notifyObservers()
}