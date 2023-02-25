package com.annadach.tests;

import com.github.javafaker.Faker;

public class TestData {

    public static String baseURL = "http://vivalo.ru/";

    static Faker faker = new Faker();

    public static String
            name = faker.name().firstName(),
            email = faker.internet().emailAddress(),
            userNumber = faker.numerify("##########"),
            message = faker.lorem().sentence(5);
}
