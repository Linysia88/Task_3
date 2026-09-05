package ru.yandex.burgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {

    private final WebDriver driver;

    private final By constructorLink =
            By.xpath("//p[text()='Конструктор']");

    private final By logo =
            By.xpath("//a[@href='/']");

    private final By logoutButton =
            By.xpath("//*[normalize-space()='Выход' or normalize-space()='Выйти']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Перейти в «Конструктор»")
    public void clickConstructor() {
        driver.findElement(constructorLink).click();
    }

    @Step("Нажать на логотип Stellar Burgers")
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    @Step("Нажать «Выйти»")
    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(logoutButton)
        ).click();
    }
}