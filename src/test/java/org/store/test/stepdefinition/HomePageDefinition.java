package org.store.test.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.store.test.assertion.Assertions;
import org.testng.asserts.SoftAssert;

import static org.store.test.AppManager.pm;
import static org.store.test.pageobject.WebElementBase.getAttributeTextContent;


public class HomePageDefinition {

    @Given("User is on Home page with categoryShop {string}, categoryRewards {string}, categoryPets {string}, " +
            "categoryFish {string} titles")
    public void userIsOnHomePage(String categoryShop, String categoryRewards, String categoryPets, String categoryFish) {
        pm().homePage().navigate();
        SoftAssert softly = new SoftAssert();
        String shopCategoryText = getAttributeTextContent(pm().homePage().element().shopCategoryHeadElement());
        String rewardsCategoryText = getAttributeTextContent(pm().homePage().element().rewardsCategoryHeadElement());
        String petsCategoryText = getAttributeTextContent(pm().homePage().element().petsCategoryHeadElement());
        String fishCategoryText = getAttributeTextContent(pm().homePage().element().fishCategoryHeadElement());
        Assertions.areResultTextsEquals(softly, shopCategoryText, categoryShop);
        Assertions.areResultTextsEquals(softly, rewardsCategoryText, categoryRewards);
        Assertions.areResultTextsEquals(softly, petsCategoryText, categoryPets);
        Assertions.areResultTextsEquals(softly, fishCategoryText, categoryFish);
        softly.assertAll();
    }

    @When("User opens the product list page with shopAll {string} button and empty cart {string}")
    public void userOpenProductListPage(String shopAllButton, String emptyCartText) {
        pm().homePage().openProductListPage();
        SoftAssert softly = new SoftAssert();
        String cartText = getAttributeTextContent(pm().homePage().cartTitleElement());
        String shopAllText = getAttributeTextContent(pm().productListPage().element().shopAllButtonElement());
        Assertions.areResultTextsEquals(softly, shopAllText, shopAllButton);
        Assertions.areResultTextsEquals(softly, cartText, emptyCartText);
        softly.assertAll();
    }

}
