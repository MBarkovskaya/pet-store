package org.store.test.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.store.test.pageobject.Page;
import org.testng.asserts.SoftAssert;

import static org.store.test.pageobject.BaseMethods.getAttributeTextContent;
import static org.store.test.pageobject.Page.assertions;
import static org.store.test.pageobject.Page.homePage;

public class HomePageDefinition {

    @Given("User is on Home page with categoryShop {string}, categoryRewards {string}, categoryPets {string}, " +
            "categoryFish {string} titles")
    public void userIsOnHomePage(String categoryShop, String categoryRewards, String categoryPets, String categoryFish) {
        homePage().navigate();
        SoftAssert softly = new SoftAssert();
        String shopCategoryText = getAttributeTextContent(Page.homePageElement().shopCategoryHeadElement());
        String rewardsCategoryText = getAttributeTextContent(Page.homePageElement().rewardsCategoryHeadElement());
        String petsCategoryText = getAttributeTextContent(Page.homePageElement().petsCategoryHeadElement());
        String fishCategoryText = getAttributeTextContent(Page.homePageElement().fishCategoryHeadElement());
        assertions().areResultTextsEquals(softly, shopCategoryText, categoryShop);
        assertions().areResultTextsEquals(softly, rewardsCategoryText, categoryRewards);
        assertions().areResultTextsEquals(softly, petsCategoryText, categoryPets);
        assertions().areResultTextsEquals(softly, fishCategoryText, categoryFish);
        softly.assertAll();
    }

    @When("User opens the product list page with shopAll {string} button and empty cart {string}")
    public void userOpenProductListPage(String shopAllButton, String emptyCartText) {
        homePage().openProductListPage();
        SoftAssert softly = new SoftAssert();
        String cartText = getAttributeTextContent(Page.headerElement().cartTitleElement());
        String shopAllText = getAttributeTextContent(Page.productListPageElement().shopAllButtonElement());
        assertions().areResultTextsEquals(softly, shopAllText, shopAllButton);
        assertions().areResultTextsEquals(softly, cartText, emptyCartText);
        softly.assertAll();
    }

}
