package com.patika.weatherapi.model

data class WeatherBitData(
    val clouds: Int,
    val datetime:String,
    val max_temp: Double,
    val min_temp: Double,
    val temp:Double,
    val wind_spd: Double
)