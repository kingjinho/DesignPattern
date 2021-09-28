package decorator

class WordDecorator(private val shoe: Shoe) : Shoe() {


    override fun cost() = shoe.cost() + 10
}