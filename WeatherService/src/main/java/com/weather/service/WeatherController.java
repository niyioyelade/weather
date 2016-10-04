package com.weather.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @RequestMapping("/weather")
    public Weather currentWeather(@RequestParam(value="city", defaultValue="London") String city) {
        Weather weather = new Weather();
        weather.setCityName(city);
        weather.setTempCelsius(40);
        weather.setSunsetTime("9:00");
        return weather;
    }
}
