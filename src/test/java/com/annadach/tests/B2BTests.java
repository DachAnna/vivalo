package com.annadach.tests;

import com.annadach.pages.B2BPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.annadach.tests.TestData.*;
import static io.qameta.allure.Allure.step;

@Feature("B2B page test")
public class B2BTests extends TestBase {

    B2BPage b2BPage = new B2BPage();
    private final static String REPOSITORY = "Vivalo";

    @Tag("b2btest")
    @Test
    @DisplayName("Проверка доступности страницы для бизнеса")
    void b2bPageCheck() {

        //Проверка доступности страницы для бизнеса
        step("Открываем страницу" + REPOSITORY + " для бизнеса", () -> {
            b2BPage.openPage();
        });
    }

    @Tag("b2btest")
    @Test
    @DisplayName("Проверка отправки формы обратной связи")
    void fillFormOrder() {

        step("Открываем страницу " + REPOSITORY + " для бизнеса", () -> {
            b2BPage.openPage();
        });

        step("Нажимаем на кнопку Начать продавать на" +REPOSITORY, () -> {
            b2BPage.openForm();
        });

        //Заполнение формы "Заказать услугу"
        step("Заполняем поле Имя", () -> {
            b2BPage.typeName(name);
        });
        step("Заполняем поле E-mail", () -> {
            b2BPage.typeMail(email);
        });
        step("Заполняем поле Телефон", () -> {
            b2BPage.typeNumber(userNumber);
        });
        step("Заполняем поле Сообщение", () -> {
            b2BPage.typeMessage(message);
        });

        //Отправка формы
        step("Нажимаем на кнопку Отправить", () -> {
            b2BPage.sendForm();
        });

        //Проверка попаппа обратной связи
        step("Проверяем, что форма отправилась", () -> {
            b2BPage.sendSuccess();
        });
    }
}
