package facade

class Amplifier {
    private lateinit var dvd: DvdPlayer
    private var volume : Int = 0
    fun on() {
        println("Amp is on")
    }

    fun setDvd(dvd: DvdPlayer) {
        this.dvd = dvd
    }

    fun setSurroundSound() {
        println("Amp is set to Surround System")
    }

    fun setVolume(volume: Int) {
        this.volume = volume
    }

    fun off() {
        println("turning off Amp")
    }
}