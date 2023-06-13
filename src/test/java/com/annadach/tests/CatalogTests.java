package com.annadach.tests;
import com.annadach.lombok.Class;

import com.annadach.allure.Layer;
import com.annadach.pages.CatalogPage;
import com.annadach.specs.Specs;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.annadach.specs.Specs.*;
import static com.annadach.tests.TestData.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Catalog page test")
@DisplayName("Каталог и фильтр")
public class CatalogTests extends TestBase {

    CatalogPage catalogPage = new CatalogPage();
    String filterEndpoint = catalogPage.getFilterEndpoint();
    String entryEndpoint = catalogPage.getEntryEndpoint();

    @Tag("catalogtest")
    @Test
    @DisplayName("Проверка доступности Каталога")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.BLOCKER)
    @Layer("web")
    void CatalogPageCheck() {

        step("Открыть страницу Каталог", () -> {
            catalogPage.openPage();
        });
    }

    @Tag("filterstest")
    @Test
    @DisplayName("Проверка Фильров из разделов Карта и Каталог")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.NORMAL)
    @Layer("web")
    void CheckFilters() {
        step("Открыть страницу Каталог", () -> {
            catalogPage.openPage();
        });

        //Проверика на наличие фильтров во вкладке Карта
        step("Открыть фильтры из Карты", () -> {
            catalogPage.filtersFromMap();
        });
        step("Проверить наличие фильтров", () -> {
            catalogPage.checkFilters();
        });

        //Проверика на наличие фильтров во вкладке Каталог
        step("Открыть фильтры из Каталога", () -> {
            catalogPage.filtersFromCatalog();
        });
        step("Проверить наличие фильтров", () -> {
            catalogPage.checkFilters();
        });
    }

    @Tag("filterstest")
    @Test
    @DisplayName("Проверка работы фильтра по уровню занятий Начинающий")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.NORMAL)
    @Layer("web")
    void FiltersByLevel() {
        step("Открыть страницу Каталог", () -> {
            catalogPage.openPage();
        });
        step("Открыть фильтры из Карты", () -> {
            catalogPage.filtersFromMap();
        });
        step("Выбрать уровень занятий Начинающий", () -> {
            catalogPage.filtersLowLevel();
        });
        step("Нажимать кнопку Применить", () -> {
            catalogPage.filtersSubmit();
        });
        step("Проверить наличие уровня Начинающий в выдаче ", () -> {
            catalogPage.checkFiltersResult();
        });
    }

    @Tag("filterstest")
    @Test
    @DisplayName("Проверка работы фильтра")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.CRITICAL)
    @Layer("web")
    void FiltersByAll() {
        step("Открыть страницу Каталог", () -> {
            catalogPage.openPage();
        });
        step("Открыть фильтры из Карты", () -> {
            catalogPage.filtersFromMap();
        });
        step("Выбрать уровень занятий Начинающий", () -> {
            catalogPage.filtersLowLevel();
        });
        step("Нажимать кнопку Применить", () -> {
            catalogPage.filtersSubmit();
        });
        step("Проверить наличие уровня Начинающий в выдаче ", () -> {
            catalogPage.checkFiltersResult();
        });
    }

    @Tag("filterstest")
    @Test
    @AllureId("23536")
    @DisplayName("Проверка доступности метода для Фильтра")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.CRITICAL)
    @Layer("API")
    void FiltersResult() {
        step("Открыть страницу Каталог", () -> {
            catalogPage.openPage();
        });
        step("Убедиться, что фильтр по всем параметрам возвращает 200", () -> {
            given()
                    .param("directions[]", directions)
                    .param("ages[]", ages)
                    .param("hour_from", hour_from)
                    .param("hour_to", hour_to)
                    .param("days[]", days)
                    .param("price_from", price_from)
                    .param("price_to", price_to)
                    .param("action", "getAjaxFilter")
                    .spec(request)
                    .when()
                    .get(filterEndpoint)
                    .then()
                    .spec(response);
        });
    }

    @Tag("filterstest")
    @Test
    @AllureId("23535")
    @DisplayName("Проверка возврата данных занятия при вызове метода Записаться")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.CRITICAL)
    @Layer("API")
    void entryResult() {
        step("Открыть страницу Каталог", () -> {
            catalogPage.openPage();
        });
        step("Убедиться, что в ответе на метод Записаться есть данные по наименованию и описанию", () -> {
            Class response = given()
                    .spec(request)
                    .spec(requestWithHeader)
                    .when()
                    .body("lesson=" + lessonId)
                    .post(entryEndpoint)
                    .then()
                    .spec(Specs.response)
                    .extract().as(Class.class);

            assertEquals(lessonId, response.getGid());
            assertEquals(nameClass, response.getName());
            assertEquals(organization, response.getOrganization());
        });
    }
}
