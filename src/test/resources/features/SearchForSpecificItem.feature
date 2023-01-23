Feature: User searches for specific item
  Background: Not logged in user is on Home page and opens the productList page
    Given User is on Home page with categoryShop "SHOP", categoryRewards "Rewards Club", categoryPets "Pets", categoryFish "Fish" titles
    When User opens the product list page with shopAll "Shop All" button and empty cart "0 Cart"

  Scenario: Not logged in user searches for specific item
    When User searches for "Koha" item
    Then User can see searching item "Koha" on the page

