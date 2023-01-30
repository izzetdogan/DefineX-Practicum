package com.patika.weatherapi.dto

import com.patika.weatherapi.model.WeatherBit


data class WeatherBitDto(
    val city_name: String,
    val country_code: String,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val data: List<WeatherBitDataDto>
){
    companion object{
        @JvmStatic
        fun convert(from: WeatherBit): WeatherBitDto{
            return WeatherBitDto(from.city_name,
            from.country_code,
            from.lat,
            from.lon,
            from.timezone,
            from.data.stream().map { WeatherBitDataDto.convert(it) }.toList(),
            )
        }
    }
}
