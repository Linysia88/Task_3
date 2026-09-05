package ru.yandex.burgers.tests;

import org.junit.jupiter.api.Test;
import ru.yandex.burgers.pageobject.LoginPage;
import ru.yandex.burgers.pageobject.MainPage;
import ru.yandex.burgers.pageobject.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends BaseTest {

    @Test
    public void successfulRegistration() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.clickLoginButton();
        loginPage.clickRegistrationLink();

        String email = "test" + System.currentTimeMillis() + "@mail.ru";
        String password = "Password123";
        String name = "Test User";

        registrationPage.register(name, email, password);

        assertTrue(
                loginPage.isLoginPageDisplayed(),
                "После регистрации не открылась страница авторизации"
        );
    }

    @Test
    public void registrationWithShortPassword() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.clickLoginButton();
        loginPage.clickRegistrationLink();

        String email = "test" + System.currentTimeMillis() + "@mail.ru";

        registrationPage.register(
                "Test User",
                email,
                "12345"
        );

        assertTrue(
                registrationPage.isWrongPasswordMessageDisplayed(),
                "Не появилось сообщение о некорректном пароле"
        );
    }
}