package hooks;

import base.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the driver - you can change "chrome" to "firefox" to switch browsers
        driver = DriverSetup.initDriver("chrome");
    }

    @After
    public void tearDown(Scenario scenario) {
        // --- NEW: Take a screenshot if the scenario has failed ---
        ScreenshotUtil.takeScreenshotOnFailure(driver, scenario);
        
        // Quit the driver to close the browser
        DriverSetup.quitDriver();
    }
}

