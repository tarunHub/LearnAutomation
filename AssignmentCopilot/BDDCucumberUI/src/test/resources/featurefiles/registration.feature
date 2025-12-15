Feature: User Registration

  Scenario: Successful registration with valid details
    Given I am on the registration page
    When I enter valid registration details
    And I click the register button
    Then I should see a success message