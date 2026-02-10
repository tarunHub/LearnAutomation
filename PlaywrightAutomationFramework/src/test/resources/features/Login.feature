@W3Schools
Feature: User Login Functionality

  @login
  Scenario Outline: Login with various credentials
    Given I am on the login page
    When I enter username "<username>"
    And I enter password "<password>"
    And I click on login button
    Then login should "<result>"

    Examples: Valid Login Credentials
      | username      | password     | result |
      | standard_user | secret_sauce | pass   |
      | problem_user  | secret_sauce | pass   |
      | performance_glitch_user | secret_sauce | pass |

    Examples: Invalid Login Credentials
      | username      | password       | result |
      | invalid_user  | wrong_password | fail   |
      | standard_user | incorrect_password | fail |
      | locked_out_user | secret_sauce   | fail   |

  @login
  Scenario Outline: Login error message validation
    Given I am on the login page
    When I enter username "<username>"
    And I enter password "<password>"
    And I click on login button
    Then I should see an error message

    Examples: Failed Login Scenarios
      | username      | password           |
      | invalid_user  | wrong_password     |
      | standard_user | incorrect_password |
      | locked_out_user | secret_sauce     |

  @login
  Scenario Outline: Successful login with title verification
    Given I am on the login page
    When I enter username "<username>"
    And I enter password "<password>"
    And I click on login button
    Then I should be logged in successfully
    And I should see "<expectedTitle>" title

    Examples: Valid Users with Expected Title
      | username      | password     | expectedTitle |
      | standard_user | secret_sauce | Products      |
      | problem_user  | secret_sauce | Products      |
      | performance_glitch_user | secret_sauce | Products |

