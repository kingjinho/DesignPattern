package factory.simple

class SmartPhoneFactory {

    fun create(type: String) : SmartPhone {
        return when (type) {
            "IPhone10" ->IPhone10()
            "IPhone11" -> IPhone11()
            "IPhone12" -> IPhone12()
            "IPhoneSE" -> IPhoneSE()
            "IPhoneSE2" -> IPhoneSE2()
            else -> IPhone9()
        }
    }
}