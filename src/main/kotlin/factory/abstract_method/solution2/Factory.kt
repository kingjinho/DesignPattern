package factory.abstract_method.solution2

import factory.EType

abstract class Factory {

    fun manufactureSmartPhone(type: EType) : SmartPhone{
        val phone = create(type)

        phone.assemble()
        phone.testVoiceCall()
        phone.testTextMessaging()
        phone.testWifi()
        phone.testInternetConnection()

        return phone
    }

    abstract fun create(type: EType) : SmartPhone
}