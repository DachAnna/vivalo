package com.annadach.tests;

import com.annadach.pages.CatalogPage;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Feature("Catalog page test")
public class CatalogTests extends TestBase{

    CatalogPage catalogPage = new CatalogPage();

    @Tag("catalogtest")
    @Test
    @DisplayName("Проверка доступности Каталога")
    void CatalogPageCheck() {

        step("Открываем страницу Каталог" , () -> {
            catalogPage.openPage();
        });
    }

    @Tag ("filterstest")
    @Test
    @DisplayName("Проверка Фильров из разделов Карта и Каталог")
    void CheckFilters(){
        step("Открываем страницу Каталог" , () -> {
            catalogPage.openPage();
        });

        //Проверика на наличие фильтров во вкладке Карта
        step("Открываем фильтры из Карты" , () -> {
            catalogPage.filtersFromMap();
        });
        step("Проверяем наличие фильтров" , () -> {
            catalogPage.checkFilters();
        });


        //Проверика на наличие фильтров во вкладке Каталог
        step("Открываем фильтры из Каталога" , () -> {
            catalogPage.filtersFromCatalog();
        });
        step("Проверяем наличие фильтров" , () -> {
            catalogPage.checkFilters();
        });
    }

    @Tag ("filterstest")
    @Test
    @DisplayName("Проверка работы фильтра по уровню занятий Начинающий")
    void FiltersByLevel(){
        step("Открываем страницу Каталог" , () -> {
            catalogPage.openPage();
        });
        step("Открываем фильтры из Карты" , () -> {
            catalogPage.filtersFromMap();
        });
        step("Выбираем уровень занятий Начинающий" , () -> {
            catalogPage.filtersLowLevel();
        });
        step("Нажимаем кнопку Применить" , () -> {
            catalogPage.filtersSubmit();
        });
        step("Проверяем наличие уровня Начинающий в выдаче " , () -> {
            catalogPage.checkFiltersResult();
        });
    }
}
