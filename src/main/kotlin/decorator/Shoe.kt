package decorator

abstract class Shoe {

    private var description = "Unknown Shoes"

    abstract fun cost(): Int

    fun setDescription(description: String) {
        this.description = description
    }

    open fun getDescription() = description

}