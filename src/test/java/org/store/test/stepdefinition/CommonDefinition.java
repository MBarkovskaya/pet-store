package org.store.test.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.store.test.AppManager;

public class CommonDefinition {

    @Before
    public void setup() {
        AppManager.init();
    }

    @After
    public void tearDown() {
        AppManager.shutDown();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            AppManager.attachScreenshot(scenario.getName().replaceAll(" ", "_"));
        }
    }
}
