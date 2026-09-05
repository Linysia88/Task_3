package ru.yandex.burgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private final WebDriver driver;

    private final By constructorLink = By.xpath("//p[text()='Конструктор']");
    private final By logo = By.xpath("//a[@href='/']");
    private final By logoutButton = By.xpath("//button[text()='Выход']");

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
        driver.findElement(logoutButton).click();
    }
}