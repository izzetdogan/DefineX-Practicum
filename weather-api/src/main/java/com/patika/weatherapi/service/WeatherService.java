package com.patika.weatherapi.service;

import com.patika.weatherapi.component.BaseUrlGenerator;
import com.patika.weatherapi.component.DateFormatterComponent;
import com.patika.weatherapi.component.RestCallComponent;
import com.patika.weatherapi.dto.QueryParamDto;
import com.patika.weatherapi.dto.WeatherBitDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class WeatherService {

    private final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private final RestCallComponent restCallComponent;
    private final BaseUrlGenerator urlGenerator;
    private final DateFormatterComponent dateFormatterComponent;

    public WeatherService(RestCallComponent restCallComponent,
                          BaseUrlGenerator urlGenerator,
                          DateFormatterComponent dateFormatterComponent
    ) {
        this.restCallComponent = restCallComponent;
        this.urlGenerator = urlGenerator;
        this.dateFormatterComponent = dateFormatterComponent;
    }



    public WeatherBitDto getCurrentWeather(String city, String country){

        // Pass the parameters required for restCall
        // dateFormatterComponent used for begin and end date
        QueryParamDto paramDto = new QueryParamDto(
                country, city,
                dateFormatterComponent.getCurrentDay(),
                dateFormatterComponent.getDateOfPlusDay()
        );
        String url = urlGenerator.generate(paramDto);
        logger.info("Service: get current weather link {}", url);
        return WeatherBitDto.convert(restCallComponent.call(url));

    }
    public WeatherBitDto getWeekWeather(String city,String country){

        QueryParamDto paramDto = new QueryParamDto(
                country, city,
                dateFormatterComponent.getDateOfMinusWeek(),
                dateFormatterComponent.getCurrentDay()
        );
        String url = urlGenerator.generate(paramDto);
        logger.info("Service: get weekly weather link {}", url);
        return  WeatherBitDto.convert(restCallComponent.call(url));



    }
    public WeatherBitDto  getMonthWeather(String city,String country){
        QueryParamDto paramDto = new QueryParamDto(
                country, city,
                dateFormatterComponent.getDateOfMinusMonth(),
                dateFormatterComponent.getCurrentDay()
        );
        String url = urlGenerator.generate(paramDto);
        logger.info("Service: get monthly link {}", url);
        return WeatherBitDto.convert(restCallComponent.call(url));
    }



}
