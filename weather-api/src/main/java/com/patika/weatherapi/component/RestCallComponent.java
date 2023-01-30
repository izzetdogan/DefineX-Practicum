package com.patika.weatherapi.component;

import com.patika.weatherapi.exception.CityNotFoundException;
import com.patika.weatherapi.model.WeatherBit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCallComponent {
    private final RestTemplate restTemplate;

    public RestCallComponent(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherBit call(String url){
        ResponseEntity<WeatherBit> response = restTemplate.getForEntity(url, WeatherBit.class);
        // No_CONTENT = HttpStatus_204 = is200Successful
        if(response.getStatusCode()== HttpStatus.NO_CONTENT)
            throw  new CityNotFoundException("City is (required) and CountryCode(not required) not matched");

        return response.getBody();
    }

}
