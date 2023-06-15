package com.annadach.pages;

import com.codeborne.selenide.SelenideElement;

import static com.annadach.tests.TestData.baseURL;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class B2BPage {

    private SelenideElement
            pageTitle = $(".section__txx"),
            buttonForForm = $(".mn"),
            nameInput = $("#NAME"),
            emailInput = $("#EMAIL"),
            numberInput = $("#feedback_PHONE"),
            messageInput = $("#MESSAGE"),
            buttomSend = $(".callback-btb__send"),
            sendSuccess = $(".popup__content");


    private final String PAGE_TITLE = "VIVALO за счет алгоритмов предлагает юрлицам создать эффективный кросс-маркетинг";

    public void openPage() {
        open(baseURL);
        $(".header-tw__menu").$("li",2).click();
       // pageTitle.shouldHave(text(PAGE_TITLE));
    }

    public void openForm() {
        buttonForForm.click();
    }

    public void typeName(String value) {
        nameInput.setValue(value);
    }

    public void typeMail(String value) {
        emailInput.setValue(value);
    }

    public void typeNumber(String value) {
        numberInput.setValue(value);
    }

    public void typeMessage(String value) {
        messageInput.setValue(value);
    }

    public void sendForm() {
        buttomSend.click();
    }

    public void sendSuccess() {
        sendSuccess.shouldHave(text("Успешно!"));
    }

}
