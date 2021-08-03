package factory.abstract_factory

abstract class SamsungGalaxy(private val componentsFactory: ComponentsFactory) : SmartPhone() {

    override fun prepare() {
        cpu = componentsFactory.createCPU()
        screen = componentsFactory.createScreen()
        battery = componentsFactory.createBattery()
        ram = componentsFactory.createRAM()
        camera = componentsFactory.createCamera()
    }
}