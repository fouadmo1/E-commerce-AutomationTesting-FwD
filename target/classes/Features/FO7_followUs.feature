@smoke
Feature: F07_followUs | users could open followUs links

  Scenario: user opens facebook link
  Given user login successfully
  When User click on facebook link
  Then  "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: user opens twitter link
    Given user login successfully
  When User click on twitter link
  Then  "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: user opens rss link
    Given user login successfully
    When User click on rss link
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

  Scenario: user opens youtube link
    Given user login successfully
  When User click on youtube link
  Then "https://www.youtube.com/user/nopCommerce" is opened in new tab