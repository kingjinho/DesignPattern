package factory.abstract_factory

class IPhoneComponents: ComponentsFactory {

    override fun createBattery() = SmallBattery()

    override fun createRAM() = RAM_4GB()

    override fun createScreen() = OLED()

    override fun createCPU() = M1()

    override fun createCamera() = CameraA()
}