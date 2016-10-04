# weather - read me notes

#Installation and Running Instructions
Assumptions
1. Java 1.8 already installed
2. Maven 3 already installed
3. Environment Variables already set to include Java and Maven bin directories in Path
4. Git already installed

Running Instructions
1. git clone https://github.com/niyioyelade/weather.git
2. mvn clean install
3. mvn spring-boot:run
3. Launch browser on http://localhost:8080

The following tasks are outstanding in the codes

WeatherController.currentWeather - Do restful method parameter validation using @Valid or manual coding. 
Throw hppt error code 400 for bad request if cityName is empty or null