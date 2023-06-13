package com.annadach.tests;

import com.annadach.allure.Layer;
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
    @Layer("web")
    void b2bPageCheck() {

        //Проверка доступности страницы для бизнеса
        step("Открыть страницу" + REPOSITORY_B2B + " для бизнеса", () -> {
            b2BPage.openPage();
        });
    }

    @Tag("b2btest")
    @Test
    @DisplayName("Проверка отправки формы обратной связи")
    @Owner("Дяченко Анна Владимировна")
    @Severity(SeverityLevel.CRITICAL)
    @Layer("web")
    void fillFormOrder() {

        step("Открыть страницу " + REPOSITORY_B2B + " для бизнеса", () -> {
            b2BPage.openPage();
        });

        step("Нажать на кнопку Начать продавать на" + REPOSITORY_B2B, () -> {
            b2BPage.openForm();
        });

        //Заполнение формы "Заказать услугу"
        step("Заполнить поле Имя", () -> {
            b2BPage.typeName(name);
        });
        step("Заполнить поле E-mail", () -> {
            b2BPage.typeMail(email);
        });
        step("Заполнить поле Телефон", () -> {
            b2BPage.typeNumber(userNumber);
        });
        step("Заполнить поле Сообщение", () -> {
            b2BPage.typeMessage(message);
        });

        //Отправка формы
        step("Нажимать на кнопку Отправить", () -> {
            b2BPage.sendForm();
        });

        //Проверка попаппа обратной связи
        step("Проверить, что форма отправилась", () -> {
            b2BPage.sendSuccess();
        });
    }
}
