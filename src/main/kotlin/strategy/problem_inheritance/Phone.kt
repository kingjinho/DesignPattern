package strategy.problem_inheritance

open class Phone {

    fun sendTextMessage(message: String, number: Int) {
        println("Sending $message to $number..")
    }

    fun makePhoneCall(number: String) {
        println("Calling $number...")
    }

    fun openWebBrowser() {
        println("Opening a Web Browser!")
    }

    fun takePhoto() {
        println("Open Camera, Take Photo!!")
    }

}