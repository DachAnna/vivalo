package com.annadach.pages;

import com.annadach.elements.MainItems;
import com.annadach.elements.MainSearchItems;
import com.codeborne.selenide.SelenideElement;

import static com.annadach.tests.TestData.baseURL;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement
            pageTitle = $(".section__txx"),
            header = $(".header-tw__menu"),
            search = $(".fltr__inner");

    private final String PAGE_TITLE = "Найдите центр дополнительного образования, секцию или кружок для своего ребенка всего за 5 кликов!\n";
    private static final String AUTH_ENDPOINT = "/auth/?fancybox=true";

    public static String getAuthEndpoint() {
        return AUTH_ENDPOINT;
    }

    public void openPage() {
        open(baseURL);
        pageTitle.shouldHave(text(PAGE_TITLE));
    }

    public MainPage checkMenuItemsEnum(MainItems menuItems) {
        header.shouldHave(text(menuItems.getDesc()));
        System.out.println("Пункт меню " + "\"" + menuItems.getDesc() + "\"" + " присутствует на главной странице");
        return this;
    }

    public MainPage checkMenuSearchEnum(MainSearchItems searchItems) {
        search.shouldHave(text(searchItems.getDesc()));
        System.out.println("Пункт поиска " + "\"" + searchItems.getDesc() + "\"" + " присутствует на главной странице");
        return this;
    }
}
