package com.example.appkkweather.domain.datasource.currentWeather

import com.example.appkkweather.db.dao.CurrentWeatherDao
import com.example.appkkweather.db.entity.CurrentWeatherEntity
import com.example.appkkweather.domain.model.CurrentWeatherResponse
import javax.inject.Inject

class CurrentWeatherLocalDataSource @Inject constructor(
    private val currentWeatherDao: CurrentWeatherDao
) {

    fun getCurrentWeather() = currentWeatherDao.getCurrentWeather()

    fun insertCurrentWeather(currentWeather: CurrentWeatherResponse) = currentWeatherDao.deleteAndInsert(
        CurrentWeatherEntity(currentWeather)
    )
}
