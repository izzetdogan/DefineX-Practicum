package com.patika.weatherapi.controller;

import com.patika.weatherapi.dto.WeatherBitDto;
import com.patika.weatherapi.exception.ParamRequiredException;
import com.patika.weatherapi.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class WeatherController {

    private final WeatherService weatherService;

    private final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/show/daily")
    public ResponseEntity<WeatherBitDto> getCurrentWeather(
            @RequestParam(value = "city",required = false)  String city,
            @RequestParam(value = "country",required = false) String country
    ){
        if (city==null) throw new ParamRequiredException("city param is required");
        logger.info("Controller Call: get Current Weather");
        return ResponseEntity.ok(weatherService.getCurrentWeather(city,country));
    }

    @GetMapping("/show/weekly")
    public ResponseEntity<WeatherBitDto> getWeeklyWeather(
            @RequestParam(value = "city",required = false) String city,
            @RequestParam(value = "country",required = false) String country
    ){
        if (city==null) throw new ParamRequiredException("city param is required");
        logger.info("Controller Call: get Weekly Weather");
        return ResponseEntity.ok(weatherService.getWeekWeather(city,country));
    }

    @GetMapping("/show/monthly")
    public ResponseEntity<WeatherBitDto> getMonthlyWeather(
            @RequestParam(value = "city",required = false) String city,
            @RequestParam(value = "country",required = false) String country
    ){
        if (city==null) throw new ParamRequiredException("city param is required");
        logger.info("Controller Call: get Monthly Weather");
        return ResponseEntity.ok(weatherService.getMonthWeather(city,country));
    }

}
