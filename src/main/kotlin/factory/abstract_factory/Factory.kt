package factory.abstract_factory

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