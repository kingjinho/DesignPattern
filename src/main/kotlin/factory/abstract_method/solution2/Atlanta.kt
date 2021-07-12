package factory.abstract_method.solution2

import factory.EType

class Atlanta : Factory() {

    override fun create(type: EType): SmartPhone {
        return when(type) {
            EType.GALAXY_S9 -> SamsungGalaxyS9()
            EType.GALAXY_S10 -> SamsungGalaxyS10()
            EType.GALAXY_S20 -> SamsungGalaxyS20()
            EType.GALAXY_S21 -> SamsungGalaxyS21()
            else -> SamsungGalaxyS8()
        }
    }
}