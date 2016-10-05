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

The following tasks are outstanding in the codes

Functionality
1. Sunrise and sunset time need to be in 12hour format with am/pm, currently it's 24hr format without am/pm.
2. UI work is yet to be done. The plan is to host the index.html on http://localhost:8080 which currently is just a hello world html page
Future work is as follows:
a. Put a drop down list of cities on the UI
b. Have a listener that fires off a javascript function when a city is selected
c. On selection, send an async GET request (ajax) to the server on http://localhost:8080/weather?city=London
d. Interprete the result in the onSUccess callback function
e. Display extracted result tests on html page with minimal formating e.g. one item per row.

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

