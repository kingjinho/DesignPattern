package factory.abstract_method.solution1


class GalaxyFactory : SmartPhoneFactory{

    override fun create(type: String) : SmartPhone {
        return when(type) {
            "GalaxyS9" -> SamsungGalaxyS9()
            "GalaxyS10" -> SamsungGalaxyS10()
            "GalaxyS20" -> SamsungGalaxyS20()
            "GalaxyS21" -> SamsungGalaxyS21()
            else -> SamsungGalaxyS8()
        }
    }
}