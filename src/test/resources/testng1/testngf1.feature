Feature: SauceLabs Login page
  As a user I  want to test whether SauceLabs login page works fine while I provide valid credentials
  Appropriate error messages should be displayed while I provide invalid credentials
  So that business people can see exceptions and success scenarios

  Background: User navigates to SauceLabs Login page
    Given User is one the SauceLabs Login Page on URL "https://saucelabs.com/beta/login"
    Then User must be able to see "New" Text
@login1
  Scenario: Appropriate error message is displayed while user provide invalid email id and password
    When User provide Username with "test1@gmail.com"
    And User provice Password with "test1password"
    And User click on Login Button
    Then I should see the "Invalid username or password" error message
    And I should be on SauceLabs Login Page with Title "Sauce Labs | Login"
@login2
  Scenario Outline: Multiple failed attempts using DDT given in below Examples
    When I provide Username with "<username>"
    And I provide Password with "<password>"
    And I click on Login Button
    Then I should view the "<errorSuccess>" message

    Examples:
      | username  | password  | errorSuccess                   |
      | test2@gmail.com  |testajsdhb | Invalid username or password |
      | test3@gmail.com  |est2kjnkdf | Invalid username or password |