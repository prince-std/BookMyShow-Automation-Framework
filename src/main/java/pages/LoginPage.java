package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WaitUtils;

/**
 * Page Object for the Login Page/Flow.
 * Contains locators and methods for the login modal.
 */
public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    // --- Locators for Home Page ---
    private By signInButton = By.xpath("//div[text()='Sign in']");

    // --- Locators for Login Modal ---
    private By mobileNumberInput = By.id("userMobileNumber");
    private By continueButton = By.xpath("//div[text()='Continue']");
    private By googleContinueButton = By.xpath("//div[text()='Continue with Google']");
    private By emailContinueButton = By.xpath("//div[text()='Continue with Email']");
    private By termsAndConditionsText = By.xpath("//div[contains(text(), 'I agree to the')]");
    private By otpVerificationHeader = By.xpath("//h3[contains(text(), 'Enter OTP sent to ')]");
    private By invalidMobileError = By.xpath("//div[text()='Invalid mobile number']");
    private By closeLoginModalButton = By.xpath("//div[@class='sc-1ydq0aj-0 bIaakI']");


    /**
     * Constructor for LoginPage.
     * @param driver The WebDriver instance.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    // --- Methods for Home Page ---
    public void clickSignIn() {
        WebElement signInBtn = waitUtils.waitForElementToBeClickable(signInButton);
        signInBtn.click();
    }
    
    // --- Methods for Login Modal ---
    public void enterMobileNumber(String mobileNumber) {
        WebElement mobileInput = waitUtils.waitForElementToBeVisible(mobileNumberInput);
       /* String selectAll = Keys.chord(Keys.CONTROL, "a");
        mobileInput.sendKeys(selectAll); // Clear the input field before entering new data
        mobileInput.sendKeys(Keys.BACK_SPACE); */
        mobileInput.clear();
        mobileInput.sendKeys(mobileNumber);
    }

    public void clickContinue() {
        WebElement continueBtn = waitUtils.waitForElementToBeClickable(continueButton);
        continueBtn.click();
    }
    
    public void closeLoginModal() {
        WebElement closeButton = waitUtils.waitForElementToBeClickable(closeLoginModalButton);
        closeButton.click();
    }

    public void verifyGoogleOptionIsVisible() {
        Assert.assertTrue(driver.findElement(googleContinueButton).isDisplayed(), "'Continue with Google' option is not visible.");
    }

    public void verifyEmailOptionIsVisible() {
        Assert.assertTrue(driver.findElement(emailContinueButton).isDisplayed(), "'Continue with Email' option is not visible.");
    }

    public void verifyTermsAndConditionsIsVisible() {
        Assert.assertTrue(driver.findElement(termsAndConditionsText).isDisplayed(), "'Terms & Conditions' text is not visible.");
    }

    public void verifyOtpScreenIsVisible() {
        WebElement otpHeader = waitUtils.waitForElementToBeVisible(otpVerificationHeader);
        Assert.assertTrue(otpHeader.isDisplayed(), "OTP Verification screen is not visible.");
    }
    
    public void verifyInvalidMobileErrorIsVisible() {
        WebElement errorElement = waitUtils.waitForElementToBeVisible(invalidMobileError);
        Assert.assertTrue(errorElement.isDisplayed(), "Error message for invalid mobile number is not displayed.");
    }
}

