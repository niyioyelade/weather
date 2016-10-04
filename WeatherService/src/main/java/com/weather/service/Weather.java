package com.weather.service;

public class Weather {

    private String todayDate;
    private String cityName;
    private  String weatherDescription;
    private  int tempCelsius;
    private  int tempFahrenheit;
    private  String sunriseTime;
    private  String sunsetTime;

    public Weather(String todayDate, String cityName, String weatherDescription, int tempCelsius, int tempFahrenheit, String sunriseTime, String sunsetTime) {
        this.todayDate = todayDate;
        this.cityName = cityName;
        this.weatherDescription = weatherDescription;
        this.tempCelsius = tempCelsius;
        this.tempFahrenheit = tempFahrenheit;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
    }

    public Weather() {

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

    public void setTempCelsius(int tempCelsius) {
        this.tempCelsius = tempCelsius;
    }

    public void setTempFahrenheit(int tempFahrenheit) {
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

    public int getTempCelsius() {
        return tempCelsius;
    }

    public int getTempFahrenheit() {
        return tempFahrenheit;
    }

    public String getSunriseTime() {
        return sunriseTime;
    }

    public String getSunsetTime() {
        return sunsetTime;
    }
}
