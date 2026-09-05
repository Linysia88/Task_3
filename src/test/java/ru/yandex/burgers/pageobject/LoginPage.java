package ru.yandex.burgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By emailField =
            By.xpath("//input[@name='name']");

    private final By passwordField =
            By.xpath("//input[@name='Пароль']");

    private final By loginButton =
            By.xpath("//button[text()='Войти']");

    private final By registrationLink =
            By.xpath("//a[text()='Зарегистрироваться']");

    private final By forgotPasswordLink =
            By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку «Войти»")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Перейти к регистрации")
    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    @Step("Перейти к восстановлению пароля")
    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    @Step("Авторизоваться под пользователем {email}")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    @Step("Проверить, что открыта страница авторизации")
    public boolean isLoginPageDisplayed() {
        return driver.findElement(emailField).isDisplayed();
    }
}