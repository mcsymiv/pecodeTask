Feature: Check login form

  Scenario: Successful login
    When I fill in the username
    And I fill in the password
    Then I see all elements on Login page
    And I click on Login Button
    Then I see Main page

  Scenario: Login with invalid user credentials
    When I fill in the username
    And I fill in the password
    And I click on Login Button
    Then I see username "No account found with that username." error message

  Scenario: Check form empty input error messages
    Given I click on Login Button
    Then I see username help block "Please enter username." error message
    Then I see password help block "Please enter your password." error message