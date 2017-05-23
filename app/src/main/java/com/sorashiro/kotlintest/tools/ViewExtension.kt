package com.sorashiro.kotlintest.tools

import android.content.Context
import android.view.View


val View.ctx: Context
    get() = context

fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> =
            map({ Pair(it.key, it.value!!) }).toTypedArray()