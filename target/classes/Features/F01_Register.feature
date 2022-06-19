@smoke
Feature: users could register with new account
  Scenario:  guest user could register with valid data successfully
    Given user go to register page
    When user select gender
    And user enter first name "alii" and "moohsn" Last name
    And user enter date of birth
    And user enter email "fouadmohamed8@gmail.com"
    And user fills password fields "123456" and "123456"
    Then user clicks on register button
    And success message is displayed

