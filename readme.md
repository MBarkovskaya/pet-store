# Selenium TestNG Project with Allure Reporting

This is a pet-store project for Selenium Page Object Model with Allure reporting.

### Libraries
* Java 17
* Allure 2.17.3
* Selenium 4.7.0
* Cucumber 7.2.3
* TestNg 7.4.0

### Steps
1. Clone this project
2. Install allure to generate results from cli (`brew install allure` for example)
3. Run tests, 
   * `mvn test` for all tests execution
   * `mvn test -Dcucumber.options="--tag @RegressionTest"` for regression tests
4. Execute `allure serve allure-results`
5. Enjoy