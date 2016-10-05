package com.weather.service;

import com.weather.service.domain.Main;
import com.weather.service.domain.OpenWeatherResponse;
import com.weather.service.domain.WeatherByCityResponse;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Oyeniyi Oyelade on 05/10/2016.
 */
public class WeatherServiceImplTest {
    @Test
    public void testweatherByCity(){
        String tempCelsius = "26.85";
        RestTemplate mockRestTemplate = mock(RestTemplate.class);

        OpenWeatherResponse response = new OpenWeatherResponse();
        Main main = new Main();
        main.setTemp("300");
        response.setMain(main);

        when(mockRestTemplate.getForObject(anyString(), any(Class.class))).thenReturn(response);

        WeatherService target = new WeatherServiceImpl(){
            @Override
            protected RestTemplate provideRestTeplate() {
                return mockRestTemplate;
            }
        };

        WeatherByCityResponse actual = target.weatherByCity("London");
        assertEquals(tempCelsius, actual.getTempCelsius());

    }
}
