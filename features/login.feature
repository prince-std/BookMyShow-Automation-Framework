@Login
Feature: Login Module Validation

Background:
Given I am on the BookMyShow homepage

@LoginUI
Scenario: Verify visibility of all login UI elements
When I click on the "Sign In" button
Then I should see the "Continue with Google" option
And I should see the "Continue with Email" option
And I should see the "I agree to the Terms & Conditions & Privacy Policy" text

@LoginDDT_Excel
Scenario: Validate login flow using data from Excel file
When I test the login functionality using the "LoginData" sheet from Excel
Then all login test cases from the sheet should be verified