package decorator

abstract class Shoe {

    private var description = "Unknown Shoes"

    fun setDescription(description: String) {
        this.description = description
    }

    abstract fun cost(): Int

    open fun getDescription() = description

}