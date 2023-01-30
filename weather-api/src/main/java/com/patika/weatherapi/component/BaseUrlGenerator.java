package com.patika.weatherapi.component;

import com.patika.weatherapi.dto.QueryParamDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseUrlGenerator {

    @Value("${weather-bit-api-key}")
    private String apiKey;
    @Value("${weather-bit-api-url}")
    private String uri;

    public String generate(QueryParamDto paramDto){
        return  uri +"daily?city="+paramDto.getCity()+
                "&country="+ paramDto.getCountry()+
                "&start_date="+paramDto.getStartDate()+
                "&end_date="+ paramDto.getEndDate()+"&key="+apiKey;

    }

}
