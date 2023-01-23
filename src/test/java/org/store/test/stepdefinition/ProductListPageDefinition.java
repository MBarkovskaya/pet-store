package org.store.test.stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.store.test.model.ItemsAndItemsNumberInCart;
import org.store.test.model.ProductItem;
import org.store.test.pageobject.Page;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.store.test.pageobject.BaseMethods.*;
import static org.store.test.pageobject.Page.*;

public class ProductListPageDefinition {

    @When("User chooses product by {string} with id {string}, {string} with id {string}, {string} with id {string}")
    public void userChooseProduct(String mainCategory, String mainCategoryId, String subcategory,
                                  String subcategoryId, String items, String itemId) {
        productListPage().selectProductCategory(mainCategoryId);
        productListPage().selectProductCategory(subcategoryId);
        productListPage().selectProductCategory(itemId);

        SoftAssert softly = new SoftAssert();
        String mainCategoryTextContent = getAttributeTextContent(productListPageElement().productItemNestedElement(1));
        actionsPause(2L);
        String subCategoryTextContent = getAttributeTextContent(productListPageElement().productItemNestedElement(2));
        actionsPause(2L);
        String itemsTextContent = getAttributeTextContent(productListPageElement().productItemNestedElement(3));
        actionsPause(2L);
        assertions().areResultTextsEquals(softly, mainCategoryTextContent, mainCategory);
        assertions().areResultTextsEquals(softly, subCategoryTextContent, subcategory);
        assertions().areResultTextsEquals(softly, itemsTextContent, items);
        softly.assertAll();
    }

    @Then("User selects 3 most expensive products and puts it into the basket")
    public void userPuts3MostExpensiveProductsIntoTheBasket() {
        List<ProductItem> limitedAndSortedAttributePriceList =
                productListPage().getLimitedAttributePriceListInDescendingOrder(productListPageElement().itemsList(), 3L);
        ItemsAndItemsNumberInCart itemsAndItemsNumberInCart = productListPage()
                .putProductListIntoTheBasket(limitedAndSortedAttributePriceList);
        SoftAssert softly = new SoftAssert();

        productListPage().openCartPage();
        assertions().areResultTextsEquals(softly, getAttributeTextContent(cartPageElement().proceedToCheckoutButton()),
                "proceed to checkout");
        String cartText = getAttributeTextContent(Page.headerElement().cartTitleElement()).trim();
        assertions().areResultTextsEquals(softly, cartText.substring(0, cartText.indexOf(" ")),
                itemsAndItemsNumberInCart.getItemsNumber());

        List<ProductItem> productItemCartList = cartPage().getProductItemList(cartPageElement().itemsList());
        assertions().areCollectionEquals(softly, itemsAndItemsNumberInCart.getProductItemList(), productItemCartList);

        softly.assertAll();
    }

    @When("User searches for {string} item")
    public void userSearchesForItem(String item) {
        productListPage().searchForItem(item);
    }

    @Then("User can see searching item {string} on the page")
    public void userVerifiesTheSearch(String item) {
        SoftAssert softly = new SoftAssert();
        List<ProductItem> productItemList =
                getProductItemList(productListPageElement().itemsList(), By.cssSelector("h3"), By.cssSelector("h4"));
        assertions().isEachCollectionElementContainsText(softly, productItemList, item);
    }
}
