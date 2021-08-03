package factory.abstract_factory

class GalaxyComponents : ComponentsFactory {
    override fun createBattery(): Battery  = BigBattery()

    override fun createRAM() = RAM_6GB()

    override fun createScreen() = QLED()

    override fun createCPU() = SnapDragon()

    override fun createCamera() = CameraB()
}