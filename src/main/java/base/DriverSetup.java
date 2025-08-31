package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

/**
 * DriverSetup class is responsible for initializing and quitting the WebDriver.
 * It supports multiple browsers and uses WebDriverManager to handle driver executables.
 */
public class DriverSetup {

    private static WebDriver driver;

    /**
     * Initializes the WebDriver instance based on the specified browser.
     * It sets up the driver, maximizes the window, and sets implicit waits.
     *
     * @param browserName The name of the browser to initialize (e.g., "chrome", "firefox").
     * @return The configured WebDriver instance.
     */
    public static WebDriver initDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
         
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        return driver;
    }

    /**
     * Quits the WebDriver instance, closing all associated browser windows.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
