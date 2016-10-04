package com.weather.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Oyeniyi Oyelade on 04/10/2016.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Main {
    @JsonProperty("temp")
    private String temp;

    public String getTemp() {
        return temp;
    }
}
