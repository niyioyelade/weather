package com.weather.service;

import com.weather.service.domain.WeatherByCityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/weather")
    public WeatherByCityResponse weather(@RequestParam(value = "city") String city) {
        //parameter check - city name should not be null or empty
        return weatherService.weatherByCity(city);
    }
}
