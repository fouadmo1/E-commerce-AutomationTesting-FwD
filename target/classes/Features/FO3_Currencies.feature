@smoke
Feature: User could Switch between currencies
    Scenario: user could switch between currencies
      Given user login successfully
      When user click on the droplist on the topleft and choose euro
      Then all currencies changed to '€'
