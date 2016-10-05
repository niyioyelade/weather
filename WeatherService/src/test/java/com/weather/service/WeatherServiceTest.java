package com.weather.service;

import com.weather.service.domain.Main;
import com.weather.service.domain.OpenWeatherResponse;
import com.weather.service.domain.WeatherByCityResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oyeniyi Oyelade on 05/10/2016.
 */
public class WeatherServiceTest {

    @Test
    public void testConvertKelvinToFahrenheiht(){
        String kelvin = "289.26";
        String expected = "61.00";
        assertEquals(expected, WeatherService.convertKelvinToFahrenHeit(kelvin));
    }
    @Test
    public void testConvertKelvinToCelsius(){
        String kelvin = "289.26";
        String expected = "16.11";
        assertEquals(expected, WeatherService.convertKelvinToCelsius(kelvin));
    }
    @Test
    public void testTranslateOpenWeatherResponse(){
        OpenWeatherResponse openWeatherResponse = new OpenWeatherResponse();
        WeatherByCityResponse translated = WeatherService.translateOpenWeatherResponse(openWeatherResponse);
        //test empty city name translation gives no errors
        assertEquals(openWeatherResponse.getName(), translated.getCityName());

        //check temp translation
        Main main = new Main();
        main.setTemp("280");
        openWeatherResponse.setMain(main);

        translated = WeatherService.translateOpenWeatherResponse(openWeatherResponse);
        assertEquals("6.85", translated.getTempCelsius());

        //more scenarios and asserts needed here


    }
}
