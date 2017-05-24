package com.sorashiro.kotlintest.extension

import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Any.logV(message: CharSequence, tag: CharSequence = javaClass.simpleName) {
    Log.v(tag.toString(), message.toString())
}