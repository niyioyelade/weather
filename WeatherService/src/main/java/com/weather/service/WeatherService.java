package com.weather.service;

import com.weather.service.domain.OpenWeatherResponse;
import com.weather.service.domain.WeatherByCityResponse;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Oyeniyi Oyelade on 04/10/2016.
 */

public interface WeatherService {

    String UI_DATE_FORMAT = "dd/MM/yyyy";
    String TIME_FORMAT = "HH:mm";

    WeatherByCityResponse weatherByCity(String cityName);


    static String convertKelvinToCelsius(String kelvin){
        Double celsiusDouble = Double.parseDouble(kelvin) -  273.15;
        return String.valueOf(celsiusDouble);
    }
    static String convertKelvinToFahrenHeit(String kelvin){
        Double fahrenheitDouble = (Double.parseDouble(kelvin) * 9 / 5) - 459.67 ;
        return String.valueOf(fahrenheitDouble);
    }
    static WeatherByCityResponse translateOpenWeatherResponse(OpenWeatherResponse openWeatherResponse){
        return new WeatherByCityResponse(new SimpleDateFormat(UI_DATE_FORMAT).format(new Date()),
                openWeatherResponse.getName(),
                openWeatherResponse.getWeather()[0].getDescription(),
                convertKelvinToCelsius(openWeatherResponse.getMain().getTemp()),
                convertKelvinToFahrenHeit(openWeatherResponse.getMain().getTemp()),
                formatTime(openWeatherResponse.getSys().getSunrise()),
                formatTime(openWeatherResponse.getSys().getSunset())
                );
    }
    static String formatTime(String timeStamp) {

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
