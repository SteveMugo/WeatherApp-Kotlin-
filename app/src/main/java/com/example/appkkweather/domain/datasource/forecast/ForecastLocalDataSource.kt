package com.example.appkkweather.domain.datasource.forecast

import com.example.appkkweather.db.dao.ForecastDao
import com.example.appkkweather.db.entity.ForecastEntity
import com.example.appkkweather.domain.model.ForecastResponse
import javax.inject.Inject

class ForecastLocalDataSource @Inject constructor(private val forecastDao: ForecastDao) {

    fun getForecast() = forecastDao.getForecast()

    fun insertForecast(forecast: ForecastResponse) = forecastDao.deleteAndInsert(
        ForecastEntity(forecast)
    )
}
