package factory.abstract_method.solution1

class Atlanta(private val factory: SmartPhoneFactory) {

    fun manufactureSmartPhone(type: String): SmartPhone {
        val phone = factory.create(type)

        phone.assemble()
        phone.testVoiceCall()
        phone.testTextMessaging()
        phone.testWifi()
        phone.testInternetConnection()

        println("All Test Passed!")

        return phone
    }
}