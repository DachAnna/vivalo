package com.annadach.elements;

public enum MainSearchItems {

    METRO("Метро"),
    DISTRICT("Район"),
    DIRECTION("Секции и увлечения"),
    AGE("Возраст"),
    DATE("Дата урока");

    private String desc;

    MainSearchItems(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
