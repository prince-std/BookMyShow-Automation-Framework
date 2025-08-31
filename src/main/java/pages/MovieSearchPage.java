package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WaitUtils;

public class MovieSearchPage {

    private WebDriver driver;
    private WaitUtils waitUtils;
 
   
    // Locators for Upcoming Movies flow
    private By upcomingMoviesLink = By.xpath("//div[@class='sc-dv5ht7-0 dLPuoR']");
    private By cinemasNearYouLink = By.xpath("//div[@class='sc-dv5ht7-0 dLPuoR']");
    // Locator for the movie title on the details page
    private By movieTitleOnDetailsPage = By.xpath("//h1[@class='sc-qswwm9-6 ea-drWB']");
    // Locators for Upcoming Movies flow
    private By moviesTab = By.xpath("//a[text()='Movies']");
    // Locators for Recommended Movies
    private By firstRecommendedMovieCard = By.xpath("//div[@class='sc-7o7nez-0 lkwOqB' and text()='Param Sundari']");
    
     //Constructor for MovieSearchPage.
    public MovieSearchPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
     //Clicks the first movie in the "Recommended Movies" section and returns its title.
     
    public String clickFirstRecommendedMovie() {
        WebElement movieCard = waitUtils.waitForElementToBeVisible(firstRecommendedMovieCard);
        
        String movieTitle = movieCard.getText();
        movieCard.click();
        return movieTitle;
    }

     public void verifyMovieTitleOnDetailsPage(String expectedTitle) {
        WebElement titleElement = waitUtils.waitForElementToBeVisible(movieTitleOnDetailsPage);
        String actualTitle = titleElement.getText();
        Assert.assertEquals(actualTitle.trim(), expectedTitle.trim(), "The movie title on the details page does not match.");
    }

    public void clickMoviesTab() {
        waitUtils.waitForElementToBeClickable(moviesTab).click();
    }
    
    public void clickUpcomingMoviesLink() {
        waitUtils.waitForElementToBeClickable(upcomingMoviesLink).click();
    }
    
    public void verifyCinemasNearYouLinkIsVisible() {
        WebElement link = waitUtils.waitForElementToBeVisible(cinemasNearYouLink);
        Assert.assertTrue(link.isDisplayed(), "'Cinemas near you' link is not visible.");
    }
}

