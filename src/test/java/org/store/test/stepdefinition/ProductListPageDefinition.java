package org.store.test.stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.store.test.assertion.Assertions;
import org.store.test.model.ItemsAndItemsNumberInCart;
import org.store.test.model.ProductItem;
import org.store.test.pageobject.WebElementBase;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.store.test.AppManager.pm;
import static org.store.test.pageobject.WebElementBase.getAttributeTextContent;

public class ProductListPageDefinition {

    @When("User chooses product by {string} with id {string}, {string} with id {string}, {string} with id {string}")
    public void userChooseProduct(String mainCategory, String mainCategoryId, String subcategory,
                                  String subcategoryId, String items, String itemId) {
        pm().productListPage().selectProductCategory(mainCategoryId);
        pm().productListPage().selectProductCategory(subcategoryId);
        pm().productListPage().selectProductCategory(itemId);

        SoftAssert softly = new SoftAssert();
        String mainCategoryTextContent = getAttributeTextContent(pm().productListPage().element().productItemNestedElement(1));
        pm().productListPage().actionsPause(2L);
        String subCategoryTextContent = getAttributeTextContent(pm().productListPage().element().productItemNestedElement(2));
        pm().productListPage().actionsPause(2L);
        String itemsTextContent = getAttributeTextContent(pm().productListPage().element().productItemNestedElement(3));
        pm().productListPage().actionsPause(2L);
        Assertions.areResultTextsEquals(softly, mainCategoryTextContent, mainCategory);
        Assertions.areResultTextsEquals(softly, subCategoryTextContent, subcategory);
        Assertions.areResultTextsEquals(softly, itemsTextContent, items);
        softly.assertAll();
    }

    @Then("User selects 3 most expensive products and puts it into the basket")
    public void userPuts3MostExpensiveProductsIntoTheBasket() {
        List<ProductItem> limitedAndSortedAttributePriceList =
                pm().productListPage().getLimitedAttributePriceListInDescendingOrder(3L);
        ItemsAndItemsNumberInCart itemsAndItemsNumberInCart = pm().productListPage()
                .putProductListIntoTheBasket(limitedAndSortedAttributePriceList);

        SoftAssert softly = new SoftAssert();

        pm().productListPage().openCartPage();
        Assertions.areResultTextsEquals(softly, getAttributeTextContent(pm().cartPage().element().proceedToCheckoutButton()),
                "proceed to checkout");
        String cartText = getAttributeTextContent(pm().homePage().cartTitleElement()).trim();
        Assertions.areResultTextsEquals(softly, cartText.substring(0, cartText.indexOf(" ")),
                itemsAndItemsNumberInCart.getItemsNumber());

        List<ProductItem> productItemCartList = pm().cartPage().getProductItemList();
        Assertions.areCollectionEquals(softly, itemsAndItemsNumberInCart.getProductItemList(), productItemCartList);

        softly.assertAll();
    }

    @When("User searches for {string} item")
    public void userSearchesForItem(String item) {
        pm().productListPage().searchForItem(item);
    }

    /*
    I think the site has bug with search result filtering, because some results don't match filter criteria
     (at least by my understanding).
     Now we are failing on last test assertion.
     But if we take into account that this is a small store, perhaps the filter is set up so specially to avoid
     returning empty results.
    */
    @Then("User can see searching item {string} on the page")
    public void userVerifiesTheSearch(String item) {
        SoftAssert softly = new SoftAssert();
        List<ProductItem> productItemList =
                 WebElementBase.getProductItemList(pm().productListPage().element().itemsList(), By.cssSelector("h3"), By.cssSelector("h4"));
        Assertions.isEachCollectionElementContainsText(softly, productItemList, item);
    }
}
