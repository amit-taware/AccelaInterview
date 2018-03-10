# ~WIP

## Important Note
* update chromedriver path according to OS in `src/test/resources/uat.properties` file `See the comment`

# Accela Interview
* Showcase Project using Selenium webdriver, Cucumber JVM as automation framework, PageObject design pattern and Maven is used as build tool.
* Java 1.8 is used as programming language and Maven is used as build tool.


### Tech Stack:
* Java 1.8
* Maven 2+
* Cucumber
* Selenium
* Chromedriver
* Junit 4.11

### Execution details:

* For local execution set flag `executeLocal=Y` in `src/test/resources/uat.properties`

#### Run the below mvn command to start the test execution
* To run the UI test Or Smoke Test (using tags) (Chrome browser)`-Dcucumber.options="--tags @UI"` :
*  mvn clean test -Denvironment=uat -Dbrowser=chrome -Dcucumber.options="--tags @UI" exec:java

### With HTML Report

* Cucumber Report `/target/cucumber-html-reports/feature-overview.html`

#### To Debug

Go to RunCukesTest.Java, select tag and test that you want to debug and run as Junit test




