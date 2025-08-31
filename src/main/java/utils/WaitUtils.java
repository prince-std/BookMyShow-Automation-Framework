package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * WaitUtils provides explicit wait helper methods for handling dynamic web elements.
 * This helps in creating more stable and reliable tests.
 */
public class WaitUtils {

    private WebDriverWait wait;

    /**
     * Constructor for WaitUtils.
     *
     * @param driver The WebDriver instance to be used for waiting.
     */
    public WaitUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /**
     * Waits for a given element to be visible on the page.
     *
     * @param locator The By locator of the element to wait for.
     * @return The WebElement once it is visible.
     */
    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for a given element to be clickable.
     *
     * @param locator The By locator of the element to wait for.
     * @return The WebElement once it is clickable.
     */
    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
