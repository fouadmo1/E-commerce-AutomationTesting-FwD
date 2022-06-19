@smoke
Feature: user could seach for products

    Scenario Outline: user could search for product using name
      Given user login successfully
      And user type the "<name>" of the product on the search field
      When user click on search Button
      Then user sees the product that he searched for "<name>"
  Examples:
    | name |
    |book  |
    |laptop|
    |nike  |

