package singleton

class ChocolateBoiler private constructor() {
    var isEmpty = true
        private set
    var isBoiled = false
        private set

    companion object {
        /*private var INSTANCE: ChocolateBoiler? = null
        fun getInstance(): ChocolateBoiler {
            return INSTANCE ?: synchronized(this) {
                val instance = ChocolateBoiler()
                INSTANCE = instance
                instance
            }
        }*/
        /*private val INSTANCE = ChocolateBoiler()
        fun getInstance(): ChocolateBoiler {
            return INSTANCE
        }*/
        @Volatile
        private var INSTANCE: ChocolateBoiler? = null

        fun getInstance(): ChocolateBoiler {
            return INSTANCE ?: synchronized(this) {
                val instance = ChocolateBoiler()
                INSTANCE = instance
                instance
            }
        }
    }

    //some other method

}