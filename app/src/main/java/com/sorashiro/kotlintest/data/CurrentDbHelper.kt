package com.sorashiro.kotlintest.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.sorashiro.kotlintest.App
import org.jetbrains.anko.db.*

class CurrentDbHelper(ctx: Context = App.instance):
        ManagedSQLiteOpenHelper(
                ctx,
                CurrentDbHelper.DB_NAME,
                null,
                CurrentDbHelper.DB_VERSION
        ){

    companion object {
        val DB_NAME = "current.db"
        val DB_VERSION = 1
        val instance: CurrentDbHelper by lazy {
            CurrentDbHelper()
        }
    }

    override fun onCreate(db: SQLiteDatabase) {

        db.createTable(
                CurrentWeatherTable.NAME, true,
                CurrentWeatherTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                CurrentWeatherTable.TEMP to REAL,
                CurrentWeatherTable.HUMIDITY to REAL
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CurrentWeatherTable.NAME, true)
        onCreate(db)
    }

}

