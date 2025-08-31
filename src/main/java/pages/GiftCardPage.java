package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WaitUtils;

/**
 * Page Object for the Gift Card functionality.
 */
public class GiftCardPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    // --- Locators ---
    private By giftCardsLink = By.xpath("//a[@class='sc-1or3vea-21 hxCjFQ' and normalize-space()='Gift Cards']");
    private By pageHeader = By.xpath("//h3[normalize-space()='Pick a card from one of our themes']");
    private By checkBalanceIcon = By.xpath("//div[normalize-space()='Check Gift Card Balance']");
    private By voucherCodeInput = By.xpath("//input[@id='gift-voucher']");
    private By checkBalanceButton = By.xpath("//div[text()='Check Balance']");
    private By errorMessage = By.xpath("//p[@class='sc-12r1n02-9 cKoKSF']");

    
    public GiftCardPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void navigateToGiftCardPage() {
        waitUtils.waitForElementToBeClickable(giftCardsLink).click();
    }

    public void verifyGiftCardPage() {
        WebElement header = waitUtils.waitForElementToBeVisible(checkBalanceIcon);
        Assert.assertTrue(header.isDisplayed(), "Not on the Gift Card page.");
        
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://in.bookmyshow.com/giftcards", "The page URL does not match the expected URL.");
    
    }

    public void verifyCheckBalanceIconIsVisible() {
        WebElement icon = waitUtils.waitForElementToBeVisible(checkBalanceIcon);
        Assert.assertTrue(icon.isDisplayed(), "'Check Gift card balance' icon is not visible.");
    }

    public void clickCheckBalanceIcon() {
        waitUtils.waitForElementToBeClickable(checkBalanceIcon).click();
    }

    public void enterVoucherCode(String voucherCode) {
        WebElement input = waitUtils.waitForElementToBeVisible(voucherCodeInput);
        input.click();
        input.sendKeys(voucherCode);
    }

    public void clickCheckBalanceButton() {
        waitUtils.waitForElementToBeClickable(checkBalanceButton).click();
    }

    public void verifyErrorMessageIsVisible() {
        WebElement error = waitUtils.waitForElementToBeVisible(errorMessage);
        Assert.assertTrue(error.isDisplayed(), "Invalid voucher error message is not visible.");
    }
}

