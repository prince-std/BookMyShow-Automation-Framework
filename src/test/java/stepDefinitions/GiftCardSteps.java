package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.GiftCardPage;

public class GiftCardSteps {

    private WebDriver driver = Hooks.driver;
    private GiftCardPage giftCardPage = new GiftCardPage(driver);
    
    // Helper method to add a pause for observation
    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click the Gift Cards link")
    public void i_click_the_gift_cards_link() {
        giftCardPage.navigateToGiftCardPage();
        sleep(2);
    }
    
    @Then("I should be on the Gift Card page")
    public void i_should_be_on_the_gift_card_page() {
        giftCardPage.verifyGiftCardPage();
    }

    @Then("the Check Gift card balance icon should be visible")
    public void the_check_gift_card_balance_icon_should_be_visible() {
        giftCardPage.verifyCheckBalanceIconIsVisible();
    }

    @When("I click the Check Gift card balance icon")
    public void i_click_the_check_gift_card_balance_icon() {
        giftCardPage.clickCheckBalanceIcon();
        sleep(1);
    }

    @When("I enter an invalid voucher code {string}")
    public void i_enter_an_invalid_voucher_code(String voucherCode) {
        giftCardPage.enterVoucherCode(voucherCode);
        sleep(1);
    }

    @When("I click the Check Balance button")
    public void i_click_the_check_balance_button() {
        giftCardPage.clickCheckBalanceButton();
        sleep(2);
    }

    @Then("I should see an invalid voucher error message")
    public void i_should_see_an_invalid_voucher_error_message() {
        giftCardPage.verifyErrorMessageIsVisible();
    }
}

