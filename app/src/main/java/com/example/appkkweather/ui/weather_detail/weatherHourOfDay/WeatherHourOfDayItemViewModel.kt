package com.example.appkkweather.ui.weather_detail.weatherHourOfDay

import androidx.databinding.ObservableField
import com.example.appkkweather.core.BaseViewModel
import com.example.appkkweather.domain.model.ListItem
import javax.inject.Inject

class WeatherHourOfDayItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<ListItem>()
}
