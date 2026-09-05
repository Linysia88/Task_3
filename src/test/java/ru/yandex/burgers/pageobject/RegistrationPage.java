package ru.yandex.burgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final WebDriver driver;

    private final By nameField =
            By.xpath("//label[text()='Имя']/following-sibling::input");

    private final By emailField =
            By.xpath("//label[text()='Email']/following-sibling::input");

    private final By passwordField =
            By.xpath("//input[@name='Пароль']");

    private final By registrationButton =
            By.xpath("//button[text()='Зарегистрироваться']");

    private final By loginLink =
            By.xpath("//a[text()='Войти']");

    private final By wrongPasswordMessage =
            By.xpath("//*[contains(text(),'Некорректный пароль')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввести имя: {name}")
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку «Зарегистрироваться»")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Перейти на страницу авторизации")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    @Step("Заполнить форму регистрации и зарегистрироваться")
    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegistrationButton();
    }

    @Step("Проверить сообщение о некорректном пароле")
    public boolean isWrongPasswordMessageDisplayed() {
        return driver.findElement(wrongPasswordMessage).isDisplayed();
    }
}