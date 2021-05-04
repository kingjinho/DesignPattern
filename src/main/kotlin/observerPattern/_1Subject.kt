package observerPattern

interface _1Subject {
    fun registerObserver(o: _2Observer)
    fun removeObserver(o: _2Observer)
    fun notifyObservers()
}