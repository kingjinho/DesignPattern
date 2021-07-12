package factory.abstract_method.solution1

class Austin(private val factory: SmartPhoneFactory) {

    fun manufactureSmartPhone(type: String): SmartPhone {
        val phone = factory.create(type)

        phone.assemble()
        phone.testInternetConnection()
        phone.testWifi()
        phone.testVoiceCall()
        phone.testTextMessaging()

        println("All Test Passed!")

        return phone
    }
}