package com.annadach.pages;

import com.codeborne.selenide.SelenideElement;

import static com.annadach.tests.TestData.baseURL;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {

    private SelenideElement
            pageSwitch = $(".sw"),
            catalogOnMain = $(".header-tw__ctl"),
            filtersFromMap = $(".ctlg__services-top").$(".ctlg__services-filter-btn"),
            filtersFromCatalog = $(".js-sw2"),
            filtersTitle = $(".ctlg-filter__top"),
            filtersItem = $(".ctlg-filter__list-item", 4),
            filtersSubmit = $(".btt-pr"),
            listItem = $(".crt-catalog__list-item", 2);


    private final String SWITCH_MAP = "Карта";
    private final String SWITCH_CATALOG = "Каталог";
    private static final String FILTER_ENDPOINT = "/local/ajax/filtr.php";
    private static final String ENTRY_ENDPOINT = "/local/ajax/api/v1/signclasses/entry.php";

    public static String getFilterEndpoint() {
        return FILTER_ENDPOINT;
    }

    public static String getEntryEndpoint() {
        return ENTRY_ENDPOINT;
    }

    public void openPage() {
        open(baseURL);
        catalogOnMain.click();
        pageSwitch.shouldHave(text(SWITCH_MAP)).shouldHave(text(SWITCH_CATALOG));
    }

    public void filtersFromMap() {
        filtersFromMap.find(byText("Показать фильтры")).click();
    }

    public void filtersFromCatalog() {
        filtersFromCatalog.click();
    }

    public void checkFilters() {
        filtersTitle.shouldHave(text("Фильтры"));
    }

    public void filtersLowLevel() {
        filtersItem.$(byText("Начинающий")).click();
    }

    public void filtersSubmit() {
        filtersSubmit.click();
    }

    public void checkFiltersResult() {
        listItem.shouldHave(text("Начинающий"));
    }
}
