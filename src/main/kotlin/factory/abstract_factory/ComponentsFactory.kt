package factory.abstract_factory

interface ComponentsFactory {

    fun createBattery() : Battery

    fun createRAM() : RAM

    fun createScreen() : Screen

    fun createCPU() : CPU

    fun createCamera() : Camera
}