package factory.without_pattern

class Brooklyn {
    fun manufactureSmartPhone(type: String): SmartPhone {
        val phone = when (type) {
            "IPhone10" ->IPhone10()
            "IPhone11" -> IPhone11()
            "IPhone12" -> IPhone12()
            "IPhoneSE" -> IPhoneSE()
            "IPhoneSE2" -> IPhoneSE2()
            "GalaxyS8" -> SamsungGalaxyS8()
            "GalaxyS9" -> SamsungGalaxyS9()
            "GalaxyS10" -> SamsungGalaxyS10()
            "GalaxyS20" -> SamsungGalaxyS20()
            "GalaxyS21" -> SamsungGalaxyS21()
            else -> IPhone9()
        }

        phone.assemble()
        phone.testInternetConnection()
        phone.testWifi()
        phone.testVoiceCall()
        phone.testTextMessaging()

        println("All Test Passed!")

        return phone
    }
}