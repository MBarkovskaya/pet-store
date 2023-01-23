package org.store.test.util;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.store.test.driver.DriverHolder.getDriver;

public class Screenshot {
    public static void attach(Scenario scenario) {
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        scenario.attach(screenshot, "img/png", screenshotName);
    }
}
