@smoke
Feature: User could add item to cart

  Scenario: user adds item to cart
    When User click add cart button for two products
    Then System add products to cart  and increase rows of Shopping cart table