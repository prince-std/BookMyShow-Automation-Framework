package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestNG Test Runner for executing Cucumber features.
 * It specifies the location of feature files, step definitions, and reporting options.
 */
@CucumberOptions(
   features = "features/login.feature", 
    glue = {"stepDefinitions", "hooks"},
    plugin = {
        "pretty",
        "html:reports/cucumber-html-report.html",
        "json:reports/cucumber.json"
    },
    monochrome = true
   
    
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // This class will be empty.
}
