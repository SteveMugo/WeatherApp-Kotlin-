package com.example.appkkweather.ui.forecast

import android.content.Context
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.example.appkkweather.data.forecast.ForecastData
import com.example.appkkweather.utils.Constants
import com.example.appkkweather.utils.Convert

class ForecastWeather(val viewModel: ForecastViewModel, val context: Context) {

    fun getForecast(progressBar: ProgressBar, data_lat: String, data_long: String) {

        progressBar.isVisible = true

        val queue = Volley.newRequestQueue(context)
        val url =
            "${Constants.BASE_URL_FORECAST}lat=$data_lat&lon=$data_long&appid=${Constants.OPEN_WEATHER_API_KEY}"

        val jsonRequest = JsonObjectRequest(Request.Method.GET, url, null, { response ->

            progressBar.isVisible = false

            //days
            val days = arrayOf(1, 2, 3, 4, 5, 6)

            for (day in days) {

                //create sonObject
                val gson = Gson()

                val temp_list =
                    response.getJSONArray("list").getJSONObject(day).getJSONObject("main")
                        .toString()//.getString("temp")
                val day_list = response.getJSONArray("list").getJSONObject(day).getString("dt")
                    .toLong()
                //icon
                val icon_list =
                    response.getJSONArray("list").getJSONObject(day).getJSONArray("weather")
                val weatherIcon = ForecastData().getWeatherIcon(icon_list.toString())

                //temperature
                val jsonString = temp_list
                val temp_model = gson.fromJson(jsonString, ForecastData.tempData::class.java)

                //temperature, min and max
                val temperature = Convert().convertTemp(temp_model.temp)
                val min_temperature = Convert().convertTemp(temp_model.temp_min)
                val max_temperature = Convert().convertTemp(temp_model.temp_max)

                //date
                val date = Constants.getDate(day_list * 1000L)

                val model =
                    forecastModel(date, temperature, weatherIcon, min_temperature, max_temperature)

                viewModel.add(model)
            }

        }, {
            Toast.makeText(context, "error fetching weather forecast", Toast.LENGTH_LONG).show()
            progressBar.isVisible = false
        })
        queue.add(jsonRequest)
    }
}