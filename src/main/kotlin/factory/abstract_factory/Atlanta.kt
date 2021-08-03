package factory.abstract_factory

import factory.EType

class Atlanta : Factory() {

    override fun create(type: EType): SmartPhone {
        val componentsFactory = GalaxyComponents()
        return when(type) {
            EType.GALAXY_S9 -> SamsungGalaxyS9(componentsFactory)
            EType.GALAXY_S10 -> SamsungGalaxyS10(componentsFactory)
            EType.GALAXY_S20 -> SamsungGalaxyS20(componentsFactory)
            EType.GALAXY_S21 -> SamsungGalaxyS21(componentsFactory)
            else -> SamsungGalaxyS8(componentsFactory)
        }
    }
}