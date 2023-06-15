package com.annadach.elements;

public enum MainItems {
    ABOUT("О нас"),
    CONTACTS("Контакты"),
    B2B("Детским центрам");

    private String desc;

    MainItems(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
