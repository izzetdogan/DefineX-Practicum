package com.patika.weatherapi.controller;

import com.patika.weatherapi.exception.CityNotFoundException;
import com.patika.weatherapi.exception.ParamRequiredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {
    @Autowired
    public MockMvc mockMvc;


// Testing Daily Test-Cases

    @Test
    void ItShouldReturnHttpStatusOkWhenParametersValidForDaily() throws Exception {
        String city ="izmir";
        String country ="Tr";
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/daily")
                        .contentType(MediaType.APPLICATION_JSON)
                .param("city",city)
                .param("country",country)
        ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void ItShouldReturnHttpStatusOkWhenCountryParamIsNullForDaily()  throws Exception{
        String city ="izmir";
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/daily")
                .param("city",city)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void ItShouldThrowParamRequiredExceptionWhenCityIsNullForDaily() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/daily")
                .param("country","tr")
        ).andExpect(result->
                Assertions.assertTrue(result.getResolvedException() instanceof ParamRequiredException));
    }
    @Test
    void ItShouldThrowCityNotFoundExceptionWhenCityIsNotMatchedForDaily() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/daily")
                .param("city","12")
        ).andExpect(result->
                Assertions.assertTrue(result.getResolvedException() instanceof CityNotFoundException));
    }


    // Testing Weekly Test Cases


    @Test
    void ItShouldReturnHttpStatusOkWhenParametersValidForWeekly() throws Exception {
        String city ="izmir";
        String country ="Tr";
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/weekly")
                .contentType(MediaType.APPLICATION_JSON)
                .param("city",city)
                .param("country",country)
        ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void ItShouldReturnHttpStatusOkWhenCountryParamIsNullForWeekly()  throws Exception{
        String city ="izmir";
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/weekly")
                .param("city",city)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void ItShouldThrowParamRequiredExceptionWhenCityIsNullForWeekly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/weekly")
                .param("country","tr")
        ).andExpect(result->
                Assertions.assertTrue(result.getResolvedException() instanceof ParamRequiredException));
    }
    @Test
    void ItShouldThrowCityNotFoundExceptionWhenCityIsNotMatchedForWeekly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/weekly")
                .param("city","12")
        ).andExpect(result->
                Assertions.assertTrue(result.getResolvedException() instanceof CityNotFoundException));
    }



    // Testing Monthly Test-Cases

    @Test
    void ItShouldReturnHttpStatusOkWhenParametersValidForMonthly() throws Exception {
        String city ="izmir";
        String country ="Tr";
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/monthly")
                .param("city",city)
                .param("country",country)
        ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void ItShouldReturnHttpStatusOkWhenCountryParamIsNullForMonthly()  throws Exception{
        String city ="izmir";
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/monthly")
                .param("city",city)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void ItShouldThrowParamRequiredExceptionWhenCityIsNullForMonthly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/monthly")
                .param("country","tr")
        ).andExpect(result->
                Assertions.assertTrue(result.getResolvedException() instanceof ParamRequiredException));
    }
    @Test
    void ItShouldThrowCityNotFoundExceptionWhenCityIsNotMatchedForMonthly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/show/monthly")
                .param("city","12")
        ).andExpect(result->
                Assertions.assertTrue(result.getResolvedException() instanceof CityNotFoundException));
    }

}
