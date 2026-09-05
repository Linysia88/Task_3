package ru.yandex.burgers.tests;

import org.junit.jupiter.api.Test;
import ru.yandex.burgers.pageobject.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    public void bunsSectionIsSelected() {
        MainPage mainPage = new MainPage(driver);

        assertTrue(
                mainPage.isBunsSectionSelected(),
                "Раздел «Булки» не выбран"
        );
    }

    @Test
    public void saucesSectionIsSelected() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesSection();

        assertTrue(
                mainPage.isSaucesSectionSelected(),
                "Раздел «Соусы» не выбран"
        );
    }

    @Test
    public void fillingsSectionIsSelected() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsSection();

        assertTrue(
                mainPage.isFillingsSectionSelected(),
                "Раздел «Начинки» не выбран"
        );
    }
}