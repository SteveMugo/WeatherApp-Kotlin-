package com.example.appkkweather.ui.dashboard

import com.example.appkkweather.core.BaseViewState
import com.example.appkkweather.db.entity.CurrentWeatherEntity
import com.example.appkkweather.utils.domain.Status

class CurrentWeatherViewState(
    val status: Status,
    val error: String? = null,
    val data: CurrentWeatherEntity? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}
