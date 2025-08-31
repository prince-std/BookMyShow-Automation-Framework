package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ExcelUtils;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.List;

/**
 * Step definitions for the Login feature, now adapted for data-driven testing from Excel.
 */
public class LoginSteps {

    private WebDriver driver = Hooks.driver;
    private LoginPage loginPage = new LoginPage(driver);

    // A list to store the test data that we read from the Excel file.
    private List<Object[]> testData;

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // --- Steps for Excel Data-Driven Test ---

    @When("I test the login functionality using the {string} sheet from Excel")
    public void i_test_the_login_functionality_using_the_sheet_from_excel(String sheetName) {
        // Read all the test data from the specified Excel sheet and store it in our list.
        testData = ExcelUtils.getTestData(sheetName);

        loginPage.clickSignIn();
        sleep(1);
        // This loop will run for each row of data in our Excel file.
        for (Object[] rowData : testData) {
            String mobileNumber = (String) rowData[0];
            String expectedResult = (String) rowData[1];

            System.out.println("Testing with Mobile Number: " + mobileNumber + " | Expected Result: " + expectedResult);

            // Start the test for the current row of data.
           

            loginPage.enterMobileNumber(mobileNumber);
            sleep(2);

          if (expectedResult.equalsIgnoreCase("OTP screen visible")) {
                loginPage.clickContinue();
                sleep(2);
                loginPage.verifyOtpScreenIsVisible();
                loginPage.closeLoginModal();
                sleep(1);
            } else if (expectedResult.equalsIgnoreCase("Invalid number error")) {
            	
                loginPage.verifyInvalidMobileErrorIsVisible();
                sleep(1);
            }
             
        }
    }

    @Then("all login test cases from the sheet should be verified")
    public void all_login_test_cases_from_the_sheet_should_be_verified() {
        // This is a simple confirmation step. The actual tests (the Asserts) happen inside the @When step.
        // If any of the assertions in the loop had failed, the test would have stopped there.
        // If we reach this step, it means all rows from the Excel sheet have been tested successfully.
        System.out.println("Successfully executed all " + testData.size() + " test cases from the Excel sheet.");
    }


    // --- Generic steps for the Login UI scenario ---

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Sign In")) {
            loginPage.clickSignIn();
            sleep(2);
        }
    }

    @Then("I should see the {string} option")
    public void i_should_see_the_option(String optionText) {
        if (optionText.equalsIgnoreCase("Continue with Google")) {
            loginPage.verifyGoogleOptionIsVisible();
        } else if (optionText.equalsIgnoreCase("Continue with Email")) {
            loginPage.verifyEmailOptionIsVisible();
        }
    }

    @Then("I should see the {string} text")
    public void i_should_see_the_text(String text) {
        if (text.contains("Terms & Conditions")) {
            loginPage.verifyTermsAndConditionsIsVisible();
        }
    }
}

