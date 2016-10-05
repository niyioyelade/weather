package com.weather.service;

import com.weather.service.domain.OpenWeatherResponse;
import com.weather.service.domain.WeatherByCityResponse;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Oyeniyi Oyelade on 04/10/2016.
 * Interface for service
 * Contains static helper methods
 */

public interface WeatherService {

    String UI_DATE_FORMAT = "dd/MM/yyyy";
    String TIME_FORMAT = "HH:mm";
    double KELVIN_TO_CALSIUS_DIFFERENCE = 273.15;
    String TEMPERATURE_PRECISION = "#0.00";

    WeatherByCityResponse weatherByCity(String cityName);


    static String convertKelvinToCelsius(String kelvin){
        if(StringUtils.isEmpty(kelvin)){
            return "";
        }
        BigDecimal kelvinBG = new BigDecimal(kelvin);
        BigDecimal celsiusBG = kelvinBG.subtract(new BigDecimal(KELVIN_TO_CALSIUS_DIFFERENCE));
        DecimalFormat dec = new DecimalFormat(TEMPERATURE_PRECISION);
        return dec.format(celsiusBG.doubleValue());
    }
    static String convertKelvinToFahrenHeit(String kelvin){
        if(StringUtils.isEmpty(kelvin)){
            return "";
        }
        BigDecimal kelvinBG = new BigDecimal(kelvin);
        BigDecimal fahrenheitBG = (kelvinBG.multiply(new BigDecimal(9)).divide(new BigDecimal(5))).subtract(new BigDecimal(459.67));
        fahrenheitBG.setScale(3, BigDecimal.ROUND_HALF_UP);
        DecimalFormat dec = new DecimalFormat(TEMPERATURE_PRECISION);
        return dec.format(fahrenheitBG.doubleValue());
    }
    static WeatherByCityResponse translateOpenWeatherResponse(OpenWeatherResponse openWeatherResponse){
        return new WeatherByCityResponse(new SimpleDateFormat(UI_DATE_FORMAT).format(new Date()),
                StringUtils.isEmpty(openWeatherResponse.getName()) ? null : openWeatherResponse.getName(),
                (openWeatherResponse.getWeather() == null || openWeatherResponse.getWeather().length == 0) ? null : openWeatherResponse.getWeather()[0].getDescription(),
                convertKelvinToCelsius((openWeatherResponse.getMain() == null) ? null : openWeatherResponse.getMain().getTemp()),
                convertKelvinToFahrenHeit((openWeatherResponse.getMain() == null) ? null : openWeatherResponse.getMain().getTemp()),
                formatTime((openWeatherResponse.getSys() == null) ? null : openWeatherResponse.getSys().getSunrise()),
                formatTime((openWeatherResponse.getSys() == null) ? null : openWeatherResponse.getSys().getSunset())
                );
    }
    static String formatTime(String timeStamp) {
        if(StringUtils.isEmpty(timeStamp)){
            return "";
        }
        return new SimpleDateFormat(TIME_FORMAT).format(new Date(Long.parseLong(timeStamp) * 1000));
    }
    static String buildRequestUrl(String cityName) {
        //make up the url
        ResourceBundle applicationProperties =  ResourceBundle.getBundle("weatherService");
        String hostName = applicationProperties.getString("weather.host");
        String weatherResource = applicationProperties.getString("weather.resource");
        String apiKey = applicationProperties.getString("api.key");
        String cityQueryParam = applicationProperties.getString("weather.cityName.queryParam");
        String appIdQueryParam = applicationProperties.getString("weather.appid.queryParam");

        StringBuilder url = new StringBuilder();
        url.append(hostName);
        url.append(weatherResource);
        url.append("?").append(cityQueryParam).append("=");
        url.append(cityName);
        url.append("&").append(appIdQueryParam).append("=");
        url.append(apiKey);
        return url.toString();
    }
}
