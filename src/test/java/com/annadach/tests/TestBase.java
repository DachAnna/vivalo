package com.annadach.tests;

import com.annadach.helpers.Attach;
import com.annadach.pages.B2BPage;
import com.annadach.pages.CatalogPage;
import com.annadach.pages.MainPage;
import com.annadach.tests.config.CredentialsConfig;
import com.codeborne.selenide.Configuration;
import com.google.common.collect.ImmutableMap;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static java.lang.String.format;

public class TestBase {

    MainPage mainPage = new MainPage();

    B2BPage b2BPage = new B2BPage();

    protected final static String REPOSITORY_MAIN = "vivalo.ru";
    protected final static String REPOSITORY_B2B = "Vivalo";
    private static final String BASE_URL = "https://vivalo.ru";

    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class, System.getProperties());

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = BASE_URL;;
        String browserSize = System.getProperty("browserSize", "2100x1080");
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion", "99");
        String baseUrl = System.getProperty("baseUrl","https://vivalo.ru");
        String remoteUrl = System.getProperty("remoteUrl", credentials.remoteUrl());
        String login = credentials.login();
        String password = credentials.password();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        /*capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);*/

        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = browserSize;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.baseUrl = baseUrl;
        Configuration.remote = format("https://%s:%s@%s", login, password, remoteUrl);
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
