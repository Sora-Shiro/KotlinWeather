package com.sorashiro.kotlintest.extension


val android.view.View.ctx: android.content.Context
    get() = context

fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> =
            map({ Pair(it.key, it.value!!) }).toTypedArray()