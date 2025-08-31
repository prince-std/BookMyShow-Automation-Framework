package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CitySearchPage;

/**
 * Step definitions for the City Search feature.
 */
public class CitySearchSteps {

    private WebDriver driver = Hooks.driver;
    private CitySearchPage citySearchPage = new CitySearchPage(driver);

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
    @When("I click on the city dropdown")
    public void i_click_on_the_city_dropdown() {
        citySearchPage.clickCityDropdown();
        sleep(2);
    }

    @When("I search for the city {string}")
    public void i_search_for_the_city(String cityName) {
        citySearchPage.searchForCity(cityName);
        sleep(3);
    }

    @Then("{string} should be visible in the search results")
    public void should_be_visible_in_the_search_results(String cityName) {
        citySearchPage.verifyCityInResults(cityName);
        sleep(2);
    }

    @When("I select {string} from the results")
    public void i_select_from_the_results(String cityName) {
        citySearchPage.selectCityFromResult(cityName);
        sleep(2);
    }

    @Then("the homepage for {string} should be displayed")
    public void the_homepage_for_should_be_displayed(String cityName) {
        citySearchPage.verifyHomePageForCity(cityName);
        sleep(3);
    }

    @Then("I should see a {string} message")
    public void i_should_see_a_message(String message) {
        if (message.equalsIgnoreCase("No results found")) {
            citySearchPage.verifyNoResultsMessage();
        }
        sleep(2);
    }

    @When("I click on {string}")
    public void i_click_on(String linkText) {
        if (linkText.equalsIgnoreCase("View All Cities")) {
            citySearchPage.clickViewAllCities();
        }
        sleep(2);
    }

    @Then("I should be on the all cities page")
    public void i_should_be_on_the_all_cities_page() {
        citySearchPage.verifyAllCitiesPage();
        sleep(2);
    }

    @Then("{string} should be a visible city option")
    public void should_be_a_visible_city_option(String cityName) {
        citySearchPage.verifyCityOnAllCitiesPage(cityName);
        sleep(2);
    }
}

