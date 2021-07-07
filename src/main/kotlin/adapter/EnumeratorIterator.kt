package adapter

import java.lang.UnsupportedOperationException
import java.util.*


class EnumeratorIterator(private val enum: Enumeration<Int>) : Iterator<Int> {

    override fun hasNext(): Boolean {
        return enum.hasMoreElements()
    }

    override fun next(): Int {
        return enum.nextElement()
    }

    fun remove() {
        throw UnsupportedOperationException()
    }
}