package decorator

class ColorDecorator(private val shoe: Shoe) : ShoeDecorator() {

    override fun cost() = shoe.cost() + 10
}