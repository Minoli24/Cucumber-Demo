Feature:Tests in Amazon Application
  Scenario:Add products to the cart successfully
    Given User navigate to the Amazon application
    Given User search product by name
    When User click on the Add to cart button of one item
    Then Item should be added to the cart successfully