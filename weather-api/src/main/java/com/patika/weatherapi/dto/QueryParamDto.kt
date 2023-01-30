package com.patika.weatherapi.dto

data class QueryParamDto(
    val country: String?,
    val city: String,
    val startDate:String,
    val endDate: String
)
