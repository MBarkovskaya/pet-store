Feature: User pays order
  Background: Not logged in user is on Home page and opens the productList page
    Given User is on Home page with categoryShop "SHOP", categoryRewards "Rewards Club", categoryPets "Pets", categoryFish "Fish" titles
    When User opens the product list page with shopAll "Shop All" button and empty cart "0 Cart"

  @RegressionTest
  Scenario: Not logged in user pays order
    When User opens the basket
    Then User verifies the basket is empty "Your cart is empty." and button with text "Continue shopping" is on the page

