package com.example.appkkweather.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object Constants {

    const val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"
    const val BASE_URL_FORECAST = "https://api.openweathermap.org/data/2.5/forecast?"
    const val OPEN_WEATHER_API_KEY = "149c99fb003a027db2dc77d1f960e994"

    @SuppressLint("SimpleDateFormat")
    fun getDate(date: Long): String {
        val timeFormatter = SimpleDateFormat("dd.MM.yyyy")
        return timeFormatter.format(Date(date * 1000L))
    }

    //cities list
    val CITIES = arrayOf(
        "Eden", "Elizabethtown", "New London", "Kampala", "Lagos", "Dakar", "Nairobi",
        "Tokyo", "Delhi", "Shanghai", "Mexico city", "Dhaka", "Cairo",
        "Beijing", "Mumbai", "Shanghai", "Osaka", "Mexico city", "Karachi",
    )
}