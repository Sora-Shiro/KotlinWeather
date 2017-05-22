package com.sorashiro.kotlintest

import android.app.Application
import com.sorashiro.kotlintest.delegate.NotNullSingleValueVar


class App : Application() {

    companion object {
        var instance: App by NotNullSingleValueVar.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}

