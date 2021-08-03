package factory.abstract_factory

import factory.EType

class Austin : Factory() {

    override fun create(type: EType): SmartPhone {
        val componentsFactory = IPhoneComponents()
        return when (type) {
            EType.IPHONE_10 -> IPhone10(componentsFactory)
            EType.IPHONE_11 -> IPhone11(componentsFactory)
            EType.IPHONE_12 -> IPhone12(componentsFactory)
            EType.IPHONE_SE -> IPhoneSE(componentsFactory)
            else -> IPhone9(componentsFactory)
        }
    }
}