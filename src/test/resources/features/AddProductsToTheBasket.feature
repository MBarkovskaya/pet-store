Feature: User adds products to the basket
  Background: Not logged in user is on Home page and opens the productList page
    Given User is on Home page with categoryShop "SHOP", categoryRewards "Rewards Club", categoryPets "Pets", categoryFish "Fish" titles
    When User opens the product list page with shopAll "Shop All" button and empty cart "0 Cart"

  Scenario Outline: Not logged in user adds 3 most expensive products then remove one of them and verify basket
    When User chooses product by <mainCategory> with id <mainCategoryId>, <subcategory> with id <subcategoryId>, <item> with id <itemId>
    Then User selects 3 most expensive products and puts it into the basket
    And User removes one of them from the basket and verifies the item is removed
    Examples:
      | mainCategory | mainCategoryId    | subcategory       | subcategoryId         | item                 | itemId                    |
      | "Cat"        | "categories_0004" | "Bowls & Feeders" | "categories_00040006" | "Feeders & Waterers" | "categories_000400060001" |
