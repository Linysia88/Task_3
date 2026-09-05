package ru.yandex.burgers.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.yandex.burgers.pageobject.WebDriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = WebDriverFactory.getWebDriver(browser);
        driver.get("https://qa-stellarburgers.education-services.ru/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}