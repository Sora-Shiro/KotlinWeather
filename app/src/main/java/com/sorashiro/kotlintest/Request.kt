package com.sorashiro.kotlintest

import com.google.gson.Gson
import com.sorashiro.kotlintest.json.CurrentWeatherJson
import java.net.URL

class CurrentWeatherRequest(val url: String) {

    fun execute(): CurrentWeatherJson {
        val jsonStr = URL(url).readText()
        return Gson().fromJson(
                jsonStr, CurrentWeatherJson::class.java)
    }

}