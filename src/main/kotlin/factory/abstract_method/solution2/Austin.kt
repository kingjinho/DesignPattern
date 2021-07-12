package factory.abstract_method.solution2

import factory.EType

class Austin : Factory() {



    override fun create(type: EType): SmartPhone {
        return when (type) {
            EType.IPHONE_10 ->IPhone10()
            EType.IPHONE_11 -> IPhone11()
            EType.IPHONE_12 -> IPhone12()
            EType.IPHONE_SE -> IPhoneSE()
            else -> IPhone9()
        }
    }
}