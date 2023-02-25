package com.annadach.tests;

public enum MainItems {
    ABOUT("О нас"),
    CONTACTS("Контакты"),
    B2B("Vivalo для бизнеса");

    private String desc;

    MainItems(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
