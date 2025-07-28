package com.example.appkkweather.data.forecast

import org.json.JSONArray

class ForecastData {

    data class dateData(val dt_txt: String)
    data class tempData(val temp: String, val temp_min: String, val temp_max: String)

    fun getWeatherIcon(json: String) : String{

        var icon = ""

        var jsonArray = JSONArray(json)
        for (jsonIndex in 0..(jsonArray.length() - 1)) {
            icon = jsonArray.getJSONObject(jsonIndex).getString("icon")
        }

        return icon
    }
}