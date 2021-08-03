package factory.abstract_factory

abstract class SmartPhone {

    var ram: RAM? = null
    var cpu: CPU? = null
    var camera: Camera? = null
    var battery: Battery? = null
    var screen: Screen? = null

    fun assemble() {
        prepare()
        println("Assembling Part")
    }

    fun testInternetConnection() {
        println("Testing Internet Connection")
    }

    fun testWifi() {
        println("Testing Wi-Fi Connection")
    }

    fun testVoiceCall() {
        println("Testing Voice Call")
    }

    fun testTextMessaging() {
        println("Testing Text Messaging")
    }

    abstract fun prepare()

}