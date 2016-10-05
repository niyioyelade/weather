package com.weather.service;


import com.weather.service.domain.OpenWeatherResponse;
import com.weather.service.domain.WeatherByCityResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Oyeniyi Oyelade on 04/10/2016.
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    private static final Logger log = Logger.getLogger("WeatherServiceImpl");
    @Override
    public WeatherByCityResponse weatherByCity(String cityName) {
        log.info("weatherByCity started");
        //parameter validation
        if(StringUtils.isEmpty(cityName)){
            throw new IllegalArgumentException("City name must be provided");
        }

        RestTemplate restTemplate = provideRestTeplate();

        //Create a list for the message converters
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

        //Add the Jackson Message converter
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        //Add the message converters to the restTemplate
        restTemplate.setMessageConverters(messageConverters);

        String url = WeatherService.buildRequestUrl(cityName);
        log.log(Level.INFO, "URL Call: " + url);

        //A simple GET request, the response will be mapped to Example.class
        OpenWeatherResponse openWeatherResponse = restTemplate.getForObject(url, OpenWeatherResponse.class);
        log.log(Level.INFO, openWeatherResponse.toString());

        //convert WeatherResponse to Weather object sent back to the web service caller
        WeatherByCityResponse weather = WeatherService.translateOpenWeatherResponse(openWeatherResponse);

        log.info("weatherByCity finished");
        return weather;

    }

    protected RestTemplate provideRestTeplate(){
        return new RestTemplate();
    }


}
