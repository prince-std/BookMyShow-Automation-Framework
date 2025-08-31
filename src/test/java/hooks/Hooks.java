package hooks;

import base.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

/**
 * This class contains Cucumber Hooks for setup and teardown operations.
 * Hooks are blocks of code that can run at various points in the Cucumber execution cycle.
 */
public class Hooks {

    public static WebDriver driver;

    /**
     * This method runs before each scenario.
     * It initializes the WebDriver instance.
     */
    @Before
    public void setUp() {
        // Initialize the driver - you can change "chrome" to "firefox" to switch browsers
        driver = DriverSetup.initDriver("chrome");
    }

    /**
     * This method runs after each scenario.
     * It takes a screenshot if the scenario fails, and then quits the driver.
     * @param scenario The current Cucumber scenario.
     */
    @After
    public void tearDown(Scenario scenario) {
        // --- NEW: Take a screenshot if the scenario has failed ---
        ScreenshotUtil.takeScreenshotOnFailure(driver, scenario);
        
        // Quit the driver to close the browser
        DriverSetup.quitDriver();
    }
}

