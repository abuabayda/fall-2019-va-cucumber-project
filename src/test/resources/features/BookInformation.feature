@wip
Feature: Books Information

  @book @db
  Scenario:  Verify book information with db
    And I am on the login page
    And I login as a librarian
    And I click on "Books" link
    When I open book The kite runner
    Then book information must match the database for The kite runner