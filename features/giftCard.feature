@GiftCard
Feature: Gift Card Functionality

Background:
Given I am on the BookMyShow homepage

@ValidateGiftCardPage
Scenario: Navigate to the Gift Card section and validate UI elements
When I click the Gift Cards link
Then I should be on the Gift Card page
And the Check Gift card balance icon should be visible

@InvalidVoucherCheck
Scenario: Validate the error message for an invalid voucher
When I click the Gift Cards link
And I click the Check Gift card balance icon
And I enter an invalid voucher code "PRINCE985455"
And I click the Check Balance button
Then I should see an invalid voucher error message