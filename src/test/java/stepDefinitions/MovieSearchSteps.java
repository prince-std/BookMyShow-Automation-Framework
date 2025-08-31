package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.MovieSearchPage;

public class MovieSearchSteps {
	 private WebDriver driver = Hooks.driver;
    private MovieSearchPage movieSearchPage = new MovieSearchPage(driver);
    private String clickedMovieTitle; // To store the title of the movie we click

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   @When("I click on the first recommended movie")
    public void i_click_on_the_first_recommended_movie() {
        // Store the title of the movie we are about to click
        clickedMovieTitle = movieSearchPage.clickFirstRecommendedMovie();
        sleep(2);
    }

    @Then("I should be on the correct movie details page")
    public void i_should_be_on_the_correct_movie_details_page() {
        // Use the stored title for verification
        movieSearchPage.verifyMovieTitleOnDetailsPage(clickedMovieTitle);
        sleep(2);
    }
    
    @When("I click on the Movies tab")
    public void i_click_on_the_movies_tab() {
        movieSearchPage.clickMoviesTab();
        sleep(1);
    }

    @When("I click on the Upcoming Movies link")
    public void i_click_on_the_upcoming_movies_link() {
        movieSearchPage.clickUpcomingMoviesLink();
        sleep(1);
    }

    @Then("the Cinemas near you link should be visible")
    public void the_cinemas_near_you_link_should_be_visible() {
        movieSearchPage.verifyCinemasNearYouLinkIsVisible();
        sleep(1);
    }
}

