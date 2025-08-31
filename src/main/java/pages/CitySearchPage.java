package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WaitUtils;

public class CitySearchPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    // --- Locators ---
    private By cityDropdown = By.xpath("//span[@class='sc-1or3vea-16 gPcyDI']");
    private By searchInput = By.xpath("//input[contains(@placeholder, 'Search for your city')]");
    private By viewAllCitiesLink = By.xpath("//p[text()='View All Cities']");
    private By noResultsMessage = By.xpath("//div[contains(text(), 'No results found')]");
    private By otherCitiesHeader = By.xpath("//p[text()='Other Cities']");
   


    public CitySearchPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

      public void clickCityDropdown() {
        WebElement dropdown = waitUtils.waitForElementToBeClickable(cityDropdown);
        dropdown.click();
    }

     public void searchForCity(String cityName) {
        WebElement input = waitUtils.waitForElementToBeVisible(searchInput);
        input.sendKeys(cityName);
    }

    public void verifyCityInResults(String cityName) {
        By cityResultLocator = By.xpath("//span[@class='sc-mrh8fw-0 ghlPza']");
        WebElement cityResult = waitUtils.waitForElementToBeVisible(cityResultLocator);
        Assert.assertTrue(cityResult.isDisplayed(), "City '" + cityName + "' was not found in search results.");
    }

    public void selectCityFromResult(String cityName) {
        By cityResultLocator = By.xpath("//span[@class='sc-mrh8fw-0 ghlPza']");
        WebElement cityResult = waitUtils.waitForElementToBeVisible(cityResultLocator);
        cityResult.click();

       }

    public void verifyHomePageForCity(String cityName) {
        By homePageCityLocator = By.xpath("//span[normalize-space()='"+cityName+"']");
        WebElement dropdown = waitUtils.waitForElementToBeVisible(homePageCityLocator);
        Assert.assertTrue(dropdown.isDisplayed(), "The city in the dropdown does not match '" + cityName + "'.");
    }


   public void verifyNoResultsMessage() {
        WebElement message = waitUtils.waitForElementToBeVisible(noResultsMessage);
        Assert.assertTrue(message.isDisplayed(), "'No results found' message was not visible.");
    }

     public void clickViewAllCities() {
        WebElement link = waitUtils.waitForElementToBeClickable(viewAllCitiesLink);
        link.click();
    }

     public void verifyAllCitiesPage() {
        WebElement header = waitUtils.waitForElementToBeVisible(otherCitiesHeader);
        Assert.assertTrue(header.isDisplayed(), "The 'Other Cities' header was not visible, so not on the all cities page.");
    }

    public void verifyCityOnAllCitiesPage(String cityName) {
        By cityLocator = By.xpath("//li[normalize-space()='" + cityName + "']");
        WebElement city = waitUtils.waitForElementToBeVisible(cityLocator);
        Assert.assertTrue(city.isDisplayed(), "City '" + cityName + "' was not found on the 'All Cities' page.");
    }
}

