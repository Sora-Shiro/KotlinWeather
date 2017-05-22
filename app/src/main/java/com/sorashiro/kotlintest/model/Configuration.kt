package com.sorashiro.kotlintest.model


class Configuration(map: Map<String, Any?>) {

    val width: Int by map
    val height: Int by map
    val dp: Int by map
    val deviceName: String by map

    val confEg = Configuration(mapOf(
            "width" to 1080,
            "height" to 720,
            "dp" to 240,
            "deviceName" to "MI 5"
    ))

}

