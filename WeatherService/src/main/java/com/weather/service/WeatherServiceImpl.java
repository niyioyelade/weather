package com.weather.service;

import com.weather.service.domain.OpenWeatherResponse;
import com.weather.service.domain.WeatherByCityResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oyeniyi Oyelade on 04/10/2016.
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public WeatherByCityResponse weatherByCity(String cityName) {

        RestTemplate restTemplate = new RestTemplate();

        //Create a list for the message converters
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

        //Add the Jackson Message converter
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);

        String url = WeatherService.buildRequestUrl(cityName);

        //A simple GET request, the response will be mapped to Example.class
        OpenWeatherResponse openWeatherResponse = restTemplate.getForObject(url, OpenWeatherResponse.class);

        //convert WeatherResponse to Weather object sent back to the web service caller
        WeatherByCityResponse weather = WeatherService.translateOpenWeatherResponse(openWeatherResponse);
        return weather;

    }


}
