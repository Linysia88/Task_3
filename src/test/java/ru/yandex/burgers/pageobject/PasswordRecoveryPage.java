package ru.yandex.burgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {

    private final WebDriver driver;

    private final By emailField = By.xpath("//input[@name='name']");
    private final By recoveryButton = By.xpath("//button[text()='Восстановить']");
    private final By loginLink = By.xpath("//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввести email для восстановления: {email}")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Нажать «Восстановить»")
    public void clickRecoveryButton() {
        driver.findElement(recoveryButton).click();
    }

    @Step("Перейти на страницу авторизации")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}