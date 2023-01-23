package org.store.test.pageobject;

import org.store.test.util.PropertyFileReader;

import static org.store.test.driver.DriverHolder.getDriver;
import static org.store.test.pageobject.BaseMethods.scrollDownToElementAndClick;

public class HomePage {
    public void navigate() {
        getDriver().navigate().to(PropertyFileReader.getProperty("siteurl"));
    }

    public void openProductListPage() {
        scrollDownToElementAndClick(Page.homePageElement().shopCategoryHeadElement());
    }
}
