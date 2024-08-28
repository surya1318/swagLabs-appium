Feature: Product order flow

  @product
  Scenario Outline: Validate the product details on the product information page
    Given user is logged in with valid credentials
    Then the product should be listed with title "<product_title>" and price "<price>"

    Examples: 
      | product_title           | price  |
      | Sauce Labs Backpack     | $29.99 |
      | Sauce Labs Bolt T-Shirt | $15.99 |

  @product
  Scenario Outline: Validate product information on Product Details page
    Given user is logged in with valid credentials
    When user clicks on the product title "<title>"
    Then user should be on product details page with product title "<title>", product price "<price>" and description "<description>"

    Examples: 
      | title               | price  | description                                                                                                                            |
      | Sauce Labs Backpack | $29.99 | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |
