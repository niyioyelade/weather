/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.weather.service;

import com.weather.service.domain.WeatherByCityResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private WeatherService weatherService;

   @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

       WeatherByCityResponse expected = new WeatherByCityResponse();
       expected.setCityName("London");
       expected.setTempCelsius("40");
       expected.setSunsetTime("9:00");
       when(weatherService.weatherByCity(anyString())).thenReturn(expected);
        /*this.mockMvc.perform(get("/weather"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tempCelsius").value("40"));*/

    }


}
