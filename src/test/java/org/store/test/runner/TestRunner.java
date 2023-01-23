package org.store.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = {"src/test/resources/features"},
        glue = {"org.store.test.stepdefinition"},
        publish = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
