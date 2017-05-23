package com.sorashiro.kotlintest.data

class CurrentWeather(var map: MutableMap<String, Any?>) {

    var _id: Long by map
    var name: String by map
    var temp: Double by map
    var humidity: Double by map

    constructor(name: String, temp: Double, humidity: Double): this(HashMap()) {
        this.name = name
        this.temp = temp
        this.humidity = humidity
    }


}
