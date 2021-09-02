package singleton

class ChocolateBoiler private constructor() {
    var isEmpty = true
        private set
    var isBoiled = false
        private set

    companion object {
        private var INSTANCE: ChocolateBoiler? = null
        fun getInstance(): ChocolateBoiler {
            if (INSTANCE == null) {
                INSTANCE = ChocolateBoiler()
            }
            return INSTANCE!!
        }
    }

    fun fill() {
        if (INSTANCE?.isEmpty!!) {
            INSTANCE?.isEmpty = false
            INSTANCE?.isBoiled = false
            // fill the boiler with a milk/chocolate mixture
        }
    }

    fun drain() {
        if (!INSTANCE?.isEmpty!! && INSTANCE?.isBoiled!!) {
            // drain the boiled milk and chocolate
            INSTANCE?.isEmpty = true
        }
    }

    fun boil() {
        if (!INSTANCE?.isEmpty!! && !INSTANCE?.isBoiled!!) {
            // bring the contents to a boil
            INSTANCE?.isBoiled = true
        }
    }

}