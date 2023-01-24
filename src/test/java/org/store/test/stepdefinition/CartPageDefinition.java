package org.store.test.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.store.test.assertion.Assertions;
import org.store.test.model.ProductItem;
import org.store.test.pageobject.WebElementBase;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.store.test.AppManager.pm;
import static org.store.test.assertion.Assertions.*;
import static org.store.test.pageobject.WebElementBase.getAttributeTextContent;

public class CartPageDefinition {

    @And("User removes one of them from the basket and verifies the item is removed")
    public void userRemovesOneItemFromTheBasketAndChecksTheBasket() {
        List<ProductItem> productItemCartListBefore =
                WebElementBase.getProductItemList(pm().cartPageElement().itemsList(), By.cssSelector("h2"), By.cssSelector("span.arial-font"));
        ProductItem productItemToBeRemoved = productItemCartListBefore.get(0);
        pm().cartPage().removeItemFromCart(productItemToBeRemoved);
        pm().cartPage().actionsPause(1L);
        List<ProductItem> productItemListAfter = pm().cartPage().getProductItemList();
        SoftAssert softly = new SoftAssert();
        collectionDoesNotContainElement(softly, productItemToBeRemoved, productItemListAfter);

        String cartText = getAttributeTextContent(pm().cartPage().cartTitleElement());
        Assertions.areResultTextsEquals(softly, cartText.substring(0, cartText.indexOf(" ")), String.valueOf(productItemListAfter.size()));
        softly.assertAll();
    }
    @When("User opens the basket")
    public void userOpensTheBasket() {
        pm().homePage().cartTitleElement().click();
        pm().homePage().actionsPause(1L);
    }

    @Then("User verifies the basket is empty {string} and button with text {string} is on the page")
    public void userVerifiesTheBasketIsEmpty(String message, String buttonText) {
        SoftAssert softly = new SoftAssert();
        isElementAbsentOnThePage(pm().cartPage(), softly, By.cssSelector("#add-cart-btn"));
        isElementOnThePage(pm().cartPage(), softly, By.cssSelector("#content_inner p"));
        areResultTextsEquals(softly, getAttributeTextContent(pm().cartPageElement().youCartIsEmptyMessage()), message);
        areResultTextsEquals(softly,
                getAttributeTextContent(pm().cartPageElement().continueShoppingButton()), buttonText);
        softly.assertAll();
    }
}
