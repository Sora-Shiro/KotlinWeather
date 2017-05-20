package com.sorashiro.kotlintest

import com.google.gson.Gson
import com.sorashiro.kotlintest.json.CurrentWeather
import com.sorashiro.kotlintest.tools.logV
import java.net.URL

class CurrentWeatherRequest(val url: String) {

    fun execute(): CurrentWeather{
        val jsonStr = URL(url).readText()
        return Gson().fromJson(
                jsonStr, CurrentWeather::class.java)
    }

}