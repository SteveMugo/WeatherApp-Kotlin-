package com.example.appkkweather.utils

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}
