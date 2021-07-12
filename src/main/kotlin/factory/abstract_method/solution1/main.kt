package factory.abstract_method.solution1

fun main(args: Array<String>) {
    val austin = Austin(IPhoneFactory())
    austin.manufactureSmartPhone("IPhone9")

    val atlanta = Atlanta(GalaxyFactory())
    atlanta.manufactureSmartPhone("Galaxy9")
}