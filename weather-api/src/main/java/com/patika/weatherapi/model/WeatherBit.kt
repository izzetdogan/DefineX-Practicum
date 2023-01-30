package com.patika.weatherapi.model

data class WeatherBit(
    val city_name: String,
    val country_code: String,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val data: List<WeatherBitData>
)