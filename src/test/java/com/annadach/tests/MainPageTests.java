package com.annadach.tests;

import com.annadach.elements.MainItems;
import com.annadach.elements.MainSearchItems;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@Feature("Main page test")
@DisplayName("Главная страница")
public class MainPageTests extends TestBase {

    @Tag("mainpagetest")
    @Test
    @AllureId("15350")
    @DisplayName("Проверка доступности сервиса/главной страницы")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.BLOCKER)
    void mainPageCheck() {

        //Проверка доступности сервиса/главной страницы
        step("Открываем главную страницу " + REPOSITORY_MAIN, () -> {
            mainPage.openPage();
        });
    }

    //Проверка наличия О нас, Контакты и Vivalo для бизнеса на главной
    @Tag("mainpagetest")
    @AllureId("15351")
    @EnumSource(value = MainItems.class, mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest(name = "Проверка наличия О нас, Контакты и Vivalo для бизнеса на главной : {0}")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.MINOR)
    void checkMenuItemsEnum(MainItems menuItems) {
        step("Открываем главную страницу " + REPOSITORY_MAIN, () -> {
            mainPage.openPage();
        });
        step("Проверяем наличие " + menuItems.getDesc() + " на главной странице", () -> {
            mainPage.checkMenuItemsEnum(menuItems);
        });
    }

    //Проверка наличия правил поиска на главной странице
    @Tag("mainpagetest")
    @AllureId("15352")
    @EnumSource(value = MainSearchItems.class, mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest(name = "Проверка наличия правил поиска на главной странице : {0}")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.NORMAL)
    void MainSearchItems(MainSearchItems searchItems) {
        step("Открываем главную страницу " + REPOSITORY_MAIN, () -> {
            mainPage.openPage();
        });
        step("Проверяем наличие правила поиска " + searchItems.getDesc() + " на главной странице", () -> {
                    mainPage.checkMenuSearchEnum(searchItems);
                }
        );
    }
}
