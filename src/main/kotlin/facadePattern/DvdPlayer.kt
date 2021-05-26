package facadePattern

class DvdPlayer {
    fun on() {
        println("Dvd Player is on")
    }

    fun play(movie: String) {
        println("Dvd Player is now playing $movie")
    }

    fun stop() {
        println("Stopped playing Dvd")
    }

    fun eject() {
        println("Ejecting DVD")
    }

    fun off() {
        println("Dvd Player is off")
    }
}