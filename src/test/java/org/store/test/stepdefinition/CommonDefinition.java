package org.store.test.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.store.test.driver.DriverFactory;
import org.store.test.driver.DriverHolder;
import org.store.test.util.PropertyFileReader;

import java.util.concurrent.TimeUnit;

public class CommonDefinition {

    @Before
    public void setup() {
        DriverHolder.setDriver(DriverFactory.getNewDriverInstance(PropertyFileReader.getProperty("browser")));
        DriverHolder.getDriver().manage().window().maximize();
        DriverHolder.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            if (scenario.isFailed()) {
//                TakesScreenshot ts = (TakesScreenshot) getDriver();
//                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "img/png", screenshotName);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DriverHolder.getDriver().quit();
    }
}
