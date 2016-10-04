package com.weather.service.domain;

public class WeatherByCityResponse {

    private String todayDate;
    private String cityName;
    private  String weatherDescription;
    private  String tempCelsius;
    private  String tempFahrenheit;
    private  String sunriseTime;
    private  String sunsetTime;

    public WeatherByCityResponse(String todayDate, String cityName, String weatherDescription, String tempCelsius, String tempFahrenheit, String sunriseTime, String sunsetTime) {
        this.todayDate = todayDate;
        this.cityName = cityName;
        this.weatherDescription = weatherDescription;
        this.tempCelsius = tempCelsius;
        this.tempFahrenheit = tempFahrenheit;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
    }

    public WeatherByCityResponse() {

    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public void setTempCelsius(String tempCelsius) {
        this.tempCelsius = tempCelsius;
    }

    public void setTempFahrenheit(String tempFahrenheit) {
        this.tempFahrenheit = tempFahrenheit;
    }

    public void setSunriseTime(String sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public void setSunsetTime(String sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public String getCityName() {
        return cityName;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getTempCelsius() {
        return tempCelsius;
    }

    public String getTempFahrenheit() {
        return tempFahrenheit;
    }

    public String getSunriseTime() {
        return sunriseTime;
    }

    public String getSunsetTime() {
        return sunsetTime;
    }
}
