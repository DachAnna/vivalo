package com.annadach.tests;

import com.annadach.allure.Layer;
import com.annadach.elements.MainItems;
import com.annadach.elements.MainSearchItems;
import com.annadach.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static com.annadach.specs.Specs.*;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static io.restassured.RestAssured.given;

@Feature("Main page test")
@DisplayName("Главная страница")
@Layer("web")
public class MainPageTests extends TestBase {

    String authEndpoint = MainPage.getAuthEndpoint();
    @Tag("mainpagetest")
    @Test
    @AllureId("15350")
    @DisplayName("Проверка доступности сервиса/главной страницы")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.BLOCKER)
    void mainPageCheck() {

        //Проверка доступности сервиса/главной страницы
        step("Открыть главную страницу " + REPOSITORY_MAIN, () -> {
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
    @Layer("web")
    void checkMenuItemsEnum(MainItems menuItems) {
        step("Открыть главную страницу " + REPOSITORY_MAIN, () -> {
            mainPage.openPage();
        });
        step("Проверить наличие " + menuItems.getDesc() + " на главной странице", () -> {
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
    @Layer("web")
    void MainSearchItems(MainSearchItems searchItems) {
        step("Открыть главную страницу " + REPOSITORY_MAIN, () -> {
            mainPage.openPage();
        });
        step("Проверить наличие правила поиска " + searchItems.getDesc() + " на главной странице", () -> {
                    mainPage.checkMenuSearchEnum(searchItems);
                }
        );
    }

    @Tag("mainpagetest")
    @Test
    @AllureId("23439")
    @DisplayName("Проверка окна авторизации на главной странице")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.CRITICAL)
    @Layer("API")
    void mainPageCheckAuth() {

        step("Открыть главную страницу " + REPOSITORY_MAIN, () -> {
            mainPage.openPage();
        });

        step("Проверить доступности окна авторизации", () -> {
            given().spec(request)
                    .spec(requestWithHeader)
                    .accept("text/html")
                    .when()
                    .get(authEndpoint)
                    .then()
                    .spec(response);
        });
    }
}
