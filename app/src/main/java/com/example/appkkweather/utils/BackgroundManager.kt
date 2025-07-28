package com.example.appkkweather.utils

import android.util.Log
import com.example.appkkweather.R

class BackgroundManager {

    //change background
    fun getBackground(background: String?): Int {

        val bg: Int = when (background) {

            "Sunny", "Clear" -> R.drawable.detailed_sunny_bg
            "Clouds" -> R.drawable.detailed_clouds_bg
            "Wind" -> R.drawable.detailed_wind_bg
            "Rain", "Storm" -> R.drawable.detailed_rainny_bg
            "Snow", "Drizzle", "Thunderstorm" -> R.drawable.detailed_snow_bg
            else -> R.drawable.detailed_default_bg
        }
        return bg
    }

    fun getHomeBackground(background: String?): Int {

        val bg: Int = when (background) {
            "Sunny", "Clouds" -> R.drawable.home_sunny
            "Clear" -> R.drawable.home_rainy
            "Rain", "Storm", "Thunderstorm" -> R.drawable.home_rainy
            "Snow", "Drizzle" -> R.drawable.detailed_snow_bg
            else -> R.drawable.home_rainy
        }
        return bg
    }

    fun getOverallHomeBackground(background: String?): Int {
        Log.d("DATA DEFN", background.toString())
        val bg: Int = when (background) {
            "Sunny" -> R.drawable.sunny_dvt
            "Clouds" -> R.drawable.cloudy_dvt
            "Rainy", "Storm", "Thunderstorm" -> R.drawable.rainy_dvt
            else -> R.drawable.forest_dvt
        }
        return bg
    }


}