package com.example.appkkweather.ui.dashboard

import com.example.appkkweather.core.BaseViewState
import com.example.appkkweather.db.entity.ForecastEntity
import com.example.appkkweather.utils.domain.Status

class ForecastViewState(
    val status: Status,
    val error: String? = null,
    val data: ForecastEntity? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}
