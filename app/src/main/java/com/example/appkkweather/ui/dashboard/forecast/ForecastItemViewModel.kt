package com.example.appkkweather.ui.dashboard.forecast

import androidx.databinding.ObservableField
import com.example.appkkweather.core.BaseViewModel
import com.example.appkkweather.domain.model.ListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForecastItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<ListItem>()
}
