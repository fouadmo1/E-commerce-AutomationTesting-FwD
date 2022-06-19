@smoke
Feature: home sliders
  Scenario: users could click on First homeslider and navigate to another tab
    Given user login successfully
    When user click on first home slider
    Then System should direct user to nokia-lumia URL "https://demo.nopcommerce.com/nokia-lumia-1020"

    Scenario:
      Given user login successfully
      When user click on sub home slider
      Then System should direct user to Iphone-6 URL "https://demo.nopcommerce.com/iphone-6"