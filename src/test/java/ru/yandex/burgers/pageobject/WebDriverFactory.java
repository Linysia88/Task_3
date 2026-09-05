package ru.yandex.burgers.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public static WebDriver getWebDriver(String browser) {

        switch (browser) {
            case "chrome":
                return new ChromeDriver();

            case "yandex":
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                System.setProperty(
                        "webdriver.chrome.driver",
                        "drivers/chromedriver"
                );
                return new ChromeDriver(options);

            default:
                throw new IllegalArgumentException(
                        "Неизвестный браузер: " + browser
                );
        }
    }
}