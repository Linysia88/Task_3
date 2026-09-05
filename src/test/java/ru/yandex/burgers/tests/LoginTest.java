package ru.yandex.burgers.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.burgers.api.UserApi;
import ru.yandex.burgers.pageobject.LoginPage;
import ru.yandex.burgers.pageobject.MainPage;
import ru.yandex.burgers.pageobject.PasswordRecoveryPage;
import ru.yandex.burgers.pageobject.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    private final UserApi userApi = new UserApi();

    private String email;
    private String password;
    private String token;

    @BeforeEach
    public void createUser() {
        email = "test" + System.currentTimeMillis() + "@mail.ru";
        password = "Password123";

        token = userApi.createUser("Test User", email, password)
                .then()
                .extract()
                .path("accessToken");
    }

    @AfterEach
    public void deleteUser() {
        if (token != null) {
            userApi.deleteUser(token);
        }
    }

    @Test
    public void loginFromMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickLoginButton();
        loginPage.login(email, password);

        assertTrue(
                driver.getCurrentUrl().contains("/"),
                "Авторизация не произошла"
        );
    }

    @Test
    public void loginFromPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.login(email, password);

        assertTrue(
                driver.getCurrentUrl().contains("/"),
                "Авторизация не произошла"
        );
    }

    @Test
    public void loginFromRegistrationPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.clickLoginButton();
        loginPage.clickRegistrationLink();
        registrationPage.clickLoginLink();

        loginPage.login(email, password);

        assertTrue(
                driver.getCurrentUrl().contains("/"),
                "Авторизация не произошла"
        );
    }

    @Test
    public void loginFromPasswordRecoveryPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PasswordRecoveryPage recoveryPage =
                new PasswordRecoveryPage(driver);

        mainPage.clickLoginButton();
        loginPage.clickForgotPasswordLink();
        recoveryPage.clickLoginLink();

        loginPage.login(email, password);

        assertTrue(
                driver.getCurrentUrl().contains("/"),
                "Авторизация не произошла"
        );
    }

}