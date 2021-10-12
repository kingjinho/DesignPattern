package decorator

class DayBreak : Shoe() {

    init {
        setDescription("DayBreak")
    }
    override fun cost() = 120
}