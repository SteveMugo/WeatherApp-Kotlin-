package com.example.appkkweather.utils

import com.example.appkkweather.model.citiesModel

class SortComparator(val cityName: String) : Comparator<citiesModel> {

    override fun compare(item1: citiesModel, item2: citiesModel): Int {
        val cityList: Int
        val orderList: Int
        cityList = if (item1.city == cityName) { 1 } else { 0 }
        orderList = if (item2.city == cityName) { 1 } else { 0 }
        return if (cityList == orderList){
            0
        } else if (cityList > orderList){
            1
        } else {
            -1
        }
    }

}