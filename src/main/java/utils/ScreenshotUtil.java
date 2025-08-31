package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;


public class ScreenshotUtil {

    /**
     * This is the only method in this class. Its job is to check if a test scenario has failed.
     * If it has, it will take a screenshot of the browser and attach it directly to the
     * Cucumber HTML report.
     *
     * @param driver   The WebDriver instance (the browser).
     * @param scenario The Cucumber scenario, which knows if it passed or failed.
     */
    public static void takeScreenshotOnFailure(WebDriver driver, Scenario scenario) {
        
        // This 'if' statement checks the result of the test. The code inside will ONLY run if the scenario failed.
        if (scenario.isFailed()) {
            
            try {
                // To take a screenshot, we need to tell the WebDriver that it "can" take screenshots.
                // We do this by converting the standard 'driver' into a 'TakesScreenshot' object.
                TakesScreenshot ts = (TakesScreenshot) driver;

                // This command takes the actual screenshot and stores it in memory as a simple array of bytes.
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                
                // This is the magic step. The 'scenario.attach' command takes the screenshot data
                // and embeds it directly into the HTML report, so you can see it later.
                // "image/png" tells the report that it's a PNG image.
                // scenario.getName() gives the screenshot a useful name based on the scenario that failed.
                scenario.attach(screenshot, "image/png", scenario.getName());
                
            } catch (Exception e) {
                // If anything goes wrong during the screenshot process, this will print an error message
                // to the console instead of crashing the whole test run.
                System.out.println("Error taking screenshot: " + e.getMessage());
            }
        }
    }
}

