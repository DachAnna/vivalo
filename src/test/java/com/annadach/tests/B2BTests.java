package com.annadach.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.annadach.tests.TestData.*;
import static io.qameta.allure.Allure.step;

@Feature("B2B page test")
@DisplayName("Страница для бизнеса")
public class B2BTests extends TestBase {



    @Tag("b2btest")
    @Test
    @DisplayName("Проверка доступности страницы для бизнеса")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.BLOCKER)
    void b2bPageCheck() {

        //Проверка доступности страницы для бизнеса
        step("Открываем страницу" + REPOSITORY_B2B + " для бизнеса", () -> {
            b2BPage.openPage();
        });
    }

    @Tag("b2btest")
    @Test
    @DisplayName("Проверка отправки формы обратной связи")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.CRITICAL)
    void fillFormOrder() {

        step("Открываем страницу " + REPOSITORY_B2B + " для бизнеса", () -> {
            b2BPage.openPage();
        });

        step("Нажимаем на кнопку Начать продавать на" + REPOSITORY_B2B, () -> {
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
