package decorator

class Jordan : Shoe() {

    init {
        setDescription("Jordan")
    }

    override fun cost() = 130

}