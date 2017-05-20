package com.sorashiro.kotlintest.json

/**
 * coord : {"lon":113.25,"lat":23.12}
 * weather : [{"id":500,"main":"Rain","description":"light rain","icon":"10d"}]
 * base : stations
 * main : {"temp":298.15,"pressure":1007,"humidity":83,"temp_min":298.15,"temp_max":298.15}
 * visibility : 7000
 * wind : {"speed":2,"deg":60}
 * clouds : {"all":90}
 * dt : 1495263600
 * sys : {"type":1,"id":7414,"message":0.0054,"country":"CN","sunrise":1495230230,"sunset":1495278209}
 * id : 1809858
 * name : Guangzhou
 * cod : 200
 */

data class CurrentWeather(
        val coord: Coord,
        val weather: List<Weather>,
        val main: Main,
        val visibility: Int,
        val wind: Wind,
        val clouds: Clouds,
        val name: String,
        val cod: Int
)

data class Coord(
        val lon: Double,
        val lat: Double
)

data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
)

data class Main(
        val temp: Double,
        val pressure: Double,
        val humidity: Double,
        val temp_min: Double,
        val temp_max: Double
)

data class Wind(
        val speed: Double,
        val deg: Double
)

data class Clouds(
        val all: Int
)