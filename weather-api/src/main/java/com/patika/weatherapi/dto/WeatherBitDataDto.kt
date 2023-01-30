package com.patika.weatherapi.dto

import com.patika.weatherapi.model.WeatherBitData

data class WeatherBitDataDto(
    val clouds: Int,
    val datetime:String,
    val max_temp: Double,
    val min_temp: Double,
    val temp:Double,
    val wind_spd: Double,
){
    companion object{
        @JvmStatic
        fun convert(from: WeatherBitData): WeatherBitDataDto{
            return WeatherBitDataDto(
                from.clouds,
                from.datetime,
                from.max_temp,
                from.min_temp,
                from.min_temp,
                from.wind_spd,
            )
        }
    }
}
