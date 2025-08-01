package com.example.appkkweather.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appkkweather.db.dao.CitiesForSearchDao
import com.example.appkkweather.db.dao.CurrentWeatherDao
import com.example.appkkweather.db.dao.ForecastDao
import com.example.appkkweather.db.entity.CitiesForSearchEntity
import com.example.appkkweather.db.entity.CurrentWeatherEntity
import com.example.appkkweather.db.entity.ForecastEntity
import com.example.appkkweather.utils.typeconverters.DataConverter

@Database(
    entities = [
        ForecastEntity::class,
        CurrentWeatherEntity::class,
        CitiesForSearchEntity::class
    ],
    version = 2
)
@TypeConverters(DataConverter::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

    abstract fun currentWeatherDao(): CurrentWeatherDao

    abstract fun citiesForSearchDao(): CitiesForSearchDao
}
