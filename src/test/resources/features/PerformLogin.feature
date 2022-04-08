Feature: Perform login

  Scenario: Successful login
    When I fill in the username
    And I fill in the password
    And I click on Login Button
    Then I see Main page

  Scenario: Login with invalid user credentials
    When I fill in the username
    And I fill in the password
    And I click on Login Button
    Then I see username "No account found with that username." error message
#    Then I see password "Please enter your password." error message

  Scenario: Check username error message
    When I fill in the username
    And I click on Login Button
    Then I see username "Please enter username." error message