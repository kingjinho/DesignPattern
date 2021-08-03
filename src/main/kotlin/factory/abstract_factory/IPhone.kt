package factory.abstract_factory

abstract class IPhone(private val componentsFactory: ComponentsFactory) : SmartPhone() {

    override fun prepare() {
        cpu = componentsFactory.createCPU()
        screen = componentsFactory.createScreen()
        ram = componentsFactory.createRAM()
        camera = componentsFactory.createCamera()
        battery = componentsFactory.createBattery()
    }

}