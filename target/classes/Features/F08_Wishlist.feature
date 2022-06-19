@smoke
Feature: user could add item to check list

  Scenario: user could add different products to Wishlist
    Given User add a product "HTC One M8 Android L 5.0 Lollipop" to his wishlist
    Then the product added to the wishlist and see success msg "wishlist"