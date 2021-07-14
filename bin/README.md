# MPowered Health Android Automation Framework
This is a Cucumber-Selenium-TestNG framework for Android automation of MPowered Health  application.

## Configuration
Under config directory, all the configuration is specified in a config.properties file.

## Test Scenarios
Under each package named as functionality name , the cucumber feature file and corresponding stepdefinition files are specofied.

## Test Data and Object Locators 
Under Data sheet directory , Test_Data.csv and Object_Repo.csv files are specified which is used for test data and object locators respectively.

## Extent Report
Under Reports directory , all the reports will be generated

## Screenshots
Under Screenshots directory , all the screenshots captured for failed cases will be updated.

## Test Execution
#### To execute  specific feature file - specify the runner files as given below under the package Runner_Files.

```
package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src\\main\\java\\Landing_welcome_positive_scenarios\\Landing_welcome_positive_scenarios.feature",
		glue= {"Landing_welcome_positive_scenarios"},
		monochrome = true,publish = true)
public class Landing_welcome_positive_scenarios_runner extends AbstractTestNGCucumberTests{

}
```

#### To execute as a regression suite
Right click on project -> Run As -> Maven test
This will execute all the testcases one by one in the manner in which testng.xml is specified.
