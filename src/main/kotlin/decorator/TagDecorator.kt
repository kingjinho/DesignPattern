package decorator

class TagDecorator(private val shoe: Shoe) : ShoeDecorator() {

    override fun cost() = shoe.cost() + 10


    override fun getDescription() = "${shoe.getDescription()}, Tag"
}