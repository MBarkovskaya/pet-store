package org.store.test.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.store.test.model.ProductItem;
import org.store.test.pageobject.Page;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.store.test.pageobject.BaseMethods.*;
import static org.store.test.pageobject.Page.*;

public class CartPageDefinition {
    @And("User removes one of them from the basket and verifies the item is removed")
    public void userRemovesOneItemFromTheBasketAndChecksTheBasket() {
        List<ProductItem> productItemCartListBefore =
                getProductItemList(cartPageElement().itemsList(), By.cssSelector("h2"), By.cssSelector("span.arial-font"));
        ProductItem productItemToBeRemoved = productItemCartListBefore.get(0);
        cartPage().removeItemFromCart(productItemToBeRemoved);
        actionsPause(1L);
        List<ProductItem> productItemListAfter = cartPage().getProductItemList(cartPageElement().itemsList());
        SoftAssert softly = new SoftAssert();
        assertions().collectionDoesNotContainElement(softly, productItemToBeRemoved, productItemListAfter);

        String cartText = getAttributeTextContent(Page.headerElement().cartTitleElement());
        actionsPause(1L);
        assertions().areResultTextsEquals(softly, cartText.substring(0, cartText.indexOf(" ")), String.valueOf(productItemListAfter.size()));
        softly.assertAll();
    }
    @When("User opens the basket")
    public void userOpensTheBasket() {
        clickOnElement(headerElement().cartTitleElement());
        actionsPause(1L);
    }

    @Then("User verifies the basket is empty {string} and button with text {string} is on the page")
    public void userVerifiesTheBasketIsEmpty(String message, String buttonText) {
        SoftAssert softly = new SoftAssert();
        assertions().isElementAbsentOnThePage(softly, By.cssSelector("#add-cart-btn"));
        assertions().isElementOnThePage(softly, By.cssSelector("#content_inner p"));
        assertions().areResultTextsEquals(softly, getAttributeTextContent(cartPageElement().youCartIsEmptyMessage()), message);
        assertions().areResultTextsEquals(softly,
                getAttributeTextContent(cartPageElement().continueShoppingButton()), buttonText);
        softly.assertAll();
    }
}
