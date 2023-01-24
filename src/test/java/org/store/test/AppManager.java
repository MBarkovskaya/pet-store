package org.store.test;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.store.test.driver.DriverFactory;
import org.store.test.pageobject.PageManager;
import org.store.test.util.PropertyFileReader;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public final class AppManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<PageManager> manager = new ThreadLocal<>();

    public static void init() {
        driver.set(DriverFactory.getNewDriverInstance(PropertyFileReader.getProperty("browser")));
        webDriver().manage().window().maximize();
        webDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        manager.set(new PageManager(webDriver()));
    }

    public static void shutDown() {
        webDriver().quit();
        driver.set(null);
    }

    public static PageManager pm() {
        return manager.get();
    }

    public static void attachScreenshot(String text) {
        TakesScreenshot ts = (TakesScreenshot) webDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(text, new ByteArrayInputStream(screenshot));
    }

    private static WebDriver webDriver() {
        return driver.get();
    }
}