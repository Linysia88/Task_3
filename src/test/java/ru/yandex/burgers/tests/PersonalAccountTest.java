package ru.yandex.burgers.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.burgers.api.UserApi;
import ru.yandex.burgers.pageobject.LoginPage;
import ru.yandex.burgers.pageobject.MainPage;
import ru.yandex.burgers.pageobject.PersonalAccountPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalAccountTest extends BaseTest {

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
    public void personalAccountOpensAfterLogin() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.login(email, password);

        mainPage.clickPersonalAccount();

        assertTrue(
                driver.getCurrentUrl().contains("/account"),
                "Личный кабинет не открылся"
        );
    }

    @Test
    public void goToConstructorFromPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.login(email, password);

        mainPage.clickPersonalAccount();
        personalAccountPage.clickConstructor();

        assertTrue(
                driver.getCurrentUrl().equals(
                        "https://qa-stellarburgers.education-services.ru/"
                ),
                "Переход в конструктор не произошёл"
        );
    }

    @Test
    public void goToConstructorByLogo() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.login(email, password);

        mainPage.clickPersonalAccount();
        personalAccountPage.clickLogo();

        assertTrue(
                driver.getCurrentUrl().equals(
                        "https://qa-stellarburgers.education-services.ru/"
                ),
                "Переход в конструктор по логотипу не произошёл"
        );
    }

    @Test
    public void logoutFromPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.clickPersonalAccount();
        loginPage.login(email, password);

        mainPage.clickPersonalAccount();
        personalAccountPage.clickLogout();

        assertTrue(
                driver.getCurrentUrl().contains("/account/profile"),
                "Выход из аккаунта не произошёл"
        );
    }
}