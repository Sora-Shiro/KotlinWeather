package com.sorashiro.kotlintest.data

import org.jetbrains.anko.db.*
import java.util.HashMap

class CurrentDb(
        val currentDbHelper: CurrentDbHelper = CurrentDbHelper.instance) {

    fun requestCurrentByCity(city: String) =
            currentDbHelper.use {
                val currentRequest = "${CurrentWeatherTable.CITY} = ?"
                val currentWeatherList = select(CurrentWeatherTable.NAME)
                        .whereSimple(currentRequest, city)
                        .parseList(classParser<CurrentWeather>())
                currentWeatherList
            }

    fun updateCurrent(currentWeather: CurrentWeather) {
        currentDbHelper.use {
            val currentRequest = "${CurrentWeatherTable.CITY} = ? " +
                    "AND ${CurrentWeatherTable.TEMP} = ? " +
                    "AND ${CurrentWeatherTable.HUMIDITY} = ?"
            update(CurrentWeatherTable.NAME, CurrentWeatherTable.CITY to currentWeather.name)
                    .whereArgs(currentRequest,
                            CurrentWeatherTable.CITY to currentWeather.name,
                            CurrentWeatherTable.TEMP to currentWeather.temp,
                            CurrentWeatherTable.HUMIDITY to currentWeather.humidity)
                    .exec()
        }
    }

    fun insertCurrent(currentWeather: CurrentWeather) {
        currentDbHelper.use {
            insert(CurrentWeatherTable.NAME,

                    CurrentWeatherTable.CITY to currentWeather.name,
                    CurrentWeatherTable.TEMP to currentWeather.temp,
                    CurrentWeatherTable.HUMIDITY to currentWeather.humidity
            )
        }
    }

    fun clearAllTable() {
        clearTable(CurrentWeatherTable.NAME)
    }

    fun clearTable(tableName: String) {
        currentDbHelper.use {
            execSQL("delete from $tableName")
        }
    }

}