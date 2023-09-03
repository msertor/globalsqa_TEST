## globalsqa_TEST
This repository contains a test for https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login using Selenium, Cucumber and Java as main tools.
First steps for reporting with TestNG and Allure but needs to be finished.  

### Installation & Prerequisites
1. JDK 17 (Ensure that the Java class path is properly set in yout system)
2. Maven (Ensure that the .m2 class path is properly set in your system)
3. Google Chrome (You could use Firefox as well, but the browser parameter in the config needs to be updated accordingly and the webdriver needs to be placed under test/resources/drivers)
4. Intellij IDE (Or your preferred IDE for Java)
   - Required Intellij Plugins (Or check the ones needed in your preferred IDE):
     - Cucumber
     - Gherkin

### Running Tests

You can run the tests from *CucumberRunnerTest* from your favorite IDE.

From command line, navigate to the project directory and run the following command to execute the features: *mvn clean test*.
By default, this command will invoke the Chrome browser and execute the tests.

To run a specific feature file among multiple feature files, use the command: mvn test -Dcucumber.options="classpath:features/my_first.feature".

### Chromedriver
The current chromedriver version is the 116, for Chrome 116 version. In case there is a new version and the 116 webdriver crashes, please download the corresponding webdriver version from here:
https://googlechromelabs.github.io/chrome-for-testing/
Then replace the files under test/resources/drivers
