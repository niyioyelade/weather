package com.weather.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Oyeniyi Oyelade on 04/10/2016.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class OpenWeatherResponse {
    @JsonProperty("name")
    private String name;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("weather")
    private Weather[] weather;

    @JsonProperty("sys")
    private Sys sys;

    public String getName() {
        return name;
    }

    public Main getMain() {
        return main;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public Sys getSys() {
        return sys;
    }
}
