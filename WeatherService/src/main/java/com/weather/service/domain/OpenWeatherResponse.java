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

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("City Name: ");
        sb.append(this.getName());
        sb.append("\n");
        sb.append("Temp in Kelvin: ");
        sb.append(this.getMain() == null ? "" : this.getMain().getTemp());
        sb.append("\n");
        sb.append("Weather description: ");
        sb.append((this.getWeather() == null || this.getWeather().length == 0) ? "" : this.getWeather()[0].getDescription());
        sb.append("\n");
        sb.append("Sunrise timestamp: ");
        sb.append(this.getSys() == null ? "" : this.getSys().getSunrise());
        sb.append("\n");
        sb.append("Sunset timestamp: ");
        sb.append(this.getSys() == null ? "" : this.getSys().getSunset());
        return sb.toString();
    }
}
