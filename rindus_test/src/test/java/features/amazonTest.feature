Feature: Rindus Amazon Test

Scenario: Verify the quantity of an item change its final price

  Given I am on Amazon home page
  When I search for "hats for men"
  And I add 2 of the item on position 1 to the cart
  And I open the cart window
  Then the quantity and price of the product is correct
  When I change in 1 the quantity of the position 1 product
  Then the quantity and price of the product is correct