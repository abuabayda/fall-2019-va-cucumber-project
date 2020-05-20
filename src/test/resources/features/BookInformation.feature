Feature: Books Information

  @book @db
  Scenario:  Verify book information with db
    And I am on the login page
    And I login as a librarian
    And I click on "Books" link
    When I open book The kite runner
    Then book information must match the database for The kite runner

  @wip @db @categories
  Scenario: Book categories validation
    Given I am on the login page
    And I login as a librarian
    When I click on "Books" link
    Then book categories must match book_categories table from db
