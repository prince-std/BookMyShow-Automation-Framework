@MovieSearch
Feature: Movie Search Functionality

Background:
Given I am on the BookMyShow homepage

@RecommendedMovie
Scenario: Select a recommended movie and verify its details page
When I click on the first recommended movie
Then I should be on the correct movie details page

@UpcomingMovies
Scenario: Validate the upcoming movies section
When I click on the Movies tab
And I click on the Upcoming Movies link
Then the Cinemas near you link should be visible