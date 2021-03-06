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
4. The server side can be tested directly from the browser with http://localhost:8080/weather?city=London



Code Quality Improvements
1. WeatherController.currentWeather - Do restful method parameter validation using @Valid or manual coding. 
Throw hppt error code 400 for bad request if cityName is empty or null
2. Improve logging - Possibly use AOP aspects and/a propper logging frmework e.g. log4j
3. Improve test line, branch  and method coverage
4. Use code quality analysis tools like SOnarQube or Cobertura to further analyse code quality and fix issues
5. Improve error handling when external API is called
6. Consider making calls to external API asynchronous - Completable Futures comes to mind
7. Finish off WeatherController unit tests, had a time wasting issue with Mockmvc from spring framework
8. Include more asserts in unit tests to improve confidence on production readiness
9. Some BDD automation acceptance tests using Java and Selenium (or any other alternatives) is recommended to automate the testing of the UI end to end user journey.
10. UI can do with some formatting.
11. Use java constants for all magic numbers and strings including empty string.
