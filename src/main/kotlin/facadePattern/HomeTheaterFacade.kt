package facadePattern

class HomeTheaterFacade(
    private val amp: Amplifier,
    private val tuner: Tuner,
    private val dvdPlayer: DvdPlayer,
    private val cdPlayer: CdPlayer,
    private val projector: Projector,
    private val lights: TheaterLights,
    private val screen: Screen,
    private val popper: PopcornPopper
) {

    fun watchMovie(movie: String) {
        println("Get ready to watch a movie")
        popper.on()
        popper.pop()
        lights.dim(10)
        screen.down()
        projector.on()
        projector.wideScreenMode()
        amp.on()
        amp.setDvd(dvdPlayer)
        amp.setSurroundSound()
        amp.setVolume(5)
        dvdPlayer.on()
        dvdPlayer.play(movie)
    }

    fun endMovie() {
        println("Shutting movie theater down...")
        popper.off()
        lights.on()
        screen.up()
        projector.off()
        amp.off()
        dvdPlayer.stop()
        dvdPlayer.eject()
        dvdPlayer.off()
    }
}