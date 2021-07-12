package factory.abstract_method.solution2

import factory.EType

fun main(args: Array<String>) {
    val austin: Factory = Austin()
    austin.manufactureSmartPhone(EType.IPHONE_12)

    val atlanta : Factory = Atlanta()
    atlanta.manufactureSmartPhone(EType.GALAXY_S9)
}