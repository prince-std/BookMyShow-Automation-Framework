Feature: City Search Module
  Background:
    Given I am on the BookMyShow homepage

  @ValidCitySearch
  Scenario: Search for a city with a valid name
    When I click on the city dropdown
    And I search for the city "Pune"
    Then "Pune" should be visible in the search results
    When I select "Pune" from the results
    Then the homepage for "Pune" should be displayed

  @InvalidCitySearch
  Scenario: Attempt to search for an invalid city
    When I click on the city dropdown
    And I search for the city "InvalidCityName"
    Then I should see a "No results found" message

  @ViewAllCities
  Scenario: View all cities and validate a non-popular city
    When I click on the city dropdown
    And I click on "View All Cities"
    Then I should be on the all cities page
    And "Ahmedabad" should be a visible city option

