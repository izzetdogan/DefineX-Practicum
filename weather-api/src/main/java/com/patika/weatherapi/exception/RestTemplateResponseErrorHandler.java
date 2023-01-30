package com.patika.weatherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;


@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {


    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {
        return (httpResponse.getStatusCode().is4xxClientError()
                || httpResponse.getStatusCode().is5xxServerError());
    }


    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {

        if (httpResponse.getStatusCode().is5xxServerError()){
            // handle SERVER_ERROR
        } else if (httpResponse.getStatusCode().is4xxClientError()){
            if (httpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new CityNotFoundException("Enter the city correctly");
            }
            if(httpResponse.getStatusCode()== HttpStatus.FORBIDDEN){
                throw  new ApiKeyInvalidException("Api keys are  invalid. You have to enter two API_KEY. https://weatherbit.io");
            }
        }
    }
}
