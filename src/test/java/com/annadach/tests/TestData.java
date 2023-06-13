package com.annadach.tests;

import com.github.javafaker.Faker;

public class TestData {

    public static String baseURL = "http://vivalo.ru/";

    static Faker faker = new Faker();

    public static String
            name = faker.name().firstName(),
            email = faker.internet().emailAddress(),
            userNumber = faker.numerify("##########"),
            message = faker.lorem().sentence(5),
            lessonId = "b3b60d773d607021806fe36fad444e30",
            nameClass = "Логопедические занятия",
            organization = "c7ee6c1be95951dffd655e6dd340d921";

    public static Integer
            directions = directionsMath(),
            ages = faker.number().numberBetween(0, 18),
            hour_from = faker.number().numberBetween(1, 24),
            hour_to = faker.number().numberBetween(1, 24),
            days = faker.number().numberBetween(1, 7),
            price_from = faker.number().numberBetween(0, 23000),
            price_to = faker.number().numberBetween(0, 23000);

    public static Integer directionsMath() {
        int direction = faker.number().numberBetween(0, 10);

        switch (direction) {
            case 0:
                direction = 345;
                break;
            case 1:
                direction = 281;
                break;
            case 2:
                direction = 286;
                break;
            case 3:
                direction = 297;
                break;
            case 4:
                direction = 267;
                break;
            case 5:
                direction = 303;
                break;
            case 6:
                direction = 309;
                break;
            case 7:
                direction = 324;
                break;
            case 8:
                direction = 329;
                break;
            case 9:
                direction = 339;
                break;
        }
        return direction;
    }
}
