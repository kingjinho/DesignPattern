package singleton

class Example {

    private constructor()

    companion object {
        private var INSTANCE: Example? = null

        fun getInstance(): Example {
            synchronized(Example::class.java) {
                if(INSTANCE == null) {
                    INSTANCE = Example()
                }
            }
            return INSTANCE!!
        }
    }
}