package com.sorashiro.kotlintest.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


object NotNullSingleValueVar {
    fun <T> notNullSingleValue():
            ReadWriteProperty<Any?, T> = NotNullSingleProperty()
}

private class NotNullSingleProperty<T>() : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {

        return value ?: throw IllegalStateException("Not Initialized")

    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {

        this.value = if (this.value == null) value
        else throw IllegalStateException("Already initialized")

    }

}
