package stepDefinitions;

import org.openqa.selenium.WebDriver;
import hooks.Hooks;
import io.cucumber.java.en.Given;

public class CommonSteps {

    private WebDriver driver = Hooks.driver;

    @Given("I am on the BookMyShow homepage")
    public void i_am_on_the_bookmyshow_homepage() {
        driver.get("https://in.bookmyshow.com/explore/home/mumbai");
    }
}

