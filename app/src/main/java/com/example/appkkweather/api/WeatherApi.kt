package com.example.appkkweather.api

import com.example.appkkweather.utils.Constants

class WeatherApi {

    fun getCurrentWeather(latitude: String, longitude: String) : String {

        var api = ""

        if (latitude.equals(null)|| longitude.equals(null)){
            api = "${Constants.BASE_URL_FORECAST}q=Nairobi&appid=${Constants.OPEN_WEATHER_API_KEY}"
        }else{
            api = "${Constants.BASE_URL}lat=$latitude&lon=$longitude&appid=${Constants.OPEN_WEATHER_API_KEY}"
        }

        return api
    }


    fun getCitiesWeather(city: String): String {
        return "${Constants.BASE_URL}q=$city&appid=${Constants.OPEN_WEATHER_API_KEY}"
    }


}