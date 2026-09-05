package ru.yandex.burgers.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    private final By loginButton =
            By.xpath("//button[text()='Войти в аккаунт']");

    private final By personalAccountLink =
            By.cssSelector("a[href='/account']");

    private final By logo =
            By.xpath("//a[@href='/']");

    private final By bunsSection =
            By.xpath("//div[contains(@class,'tab_tab')][span[text()='Булки']]");

    private final By saucesSection =
            By.xpath("//div[contains(@class,'tab_tab')][span[text()='Соусы']]");

    private final By fillingsSection =
            By.xpath("//div[contains(@class,'tab_tab')][span[text()='Начинки']]");

    private final By selectedBunsSection =
            By.xpath("//div[contains(@class,'tab_type_current')][span[text()='Булки']]");

    private final By selectedSaucesSection =
            By.xpath("//div[contains(@class,'tab_type_current')][span[text()='Соусы']]");

    private final By selectedFillingsSection =
            By.xpath("//div[contains(@class,'tab_type_current')][span[text()='Начинки']]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать «Войти в аккаунт»")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Перейти в «Личный кабинет»")
    public void clickPersonalAccount() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div[class*='Modal_modal_overlay']")
        ));

        wait.until(
                ExpectedConditions.elementToBeClickable(personalAccountLink)
        ).click();
    }

    @Step("Нажать на логотип Stellar Burgers")
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    @Step("Выбрать раздел «Булки»")
    public void clickBunsSection() {
        WebElement element = driver.findElement(bunsSection);
        element.click();
    }

    @Step("Выбрать раздел «Соусы»")
    public void clickSaucesSection() {
        WebElement element = driver.findElement(saucesSection);
        element.click();
    }

    @Step("Выбрать раздел «Начинки»")
    public void clickFillingsSection() {
        WebElement element = driver.findElement(fillingsSection);
        element.click();
    }

    @Step("Проверить, что выбран раздел «Булки»")
    public boolean isBunsSectionSelected() {
        return driver.findElement(selectedBunsSection).isDisplayed();
    }

    @Step("Проверить, что выбран раздел «Соусы»")
    public boolean isSaucesSectionSelected() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        selectedSaucesSection
                )
        ).isDisplayed();
    }

    @Step("Проверить, что выбран раздел «Начинки»")
    public boolean isFillingsSectionSelected() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        selectedFillingsSection
                )
        ).isDisplayed();
    }
}