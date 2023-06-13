package com.annadach.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.annadach.filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;

public class Specs {

    public static RequestSpecification request = with()
            .filter(customLogFilter().withCustomTemplates())
            .log().all();

    public static RequestSpecification requestWithHeader = with()
            .contentType("application/x-www-form-urlencoded")
            .header("X-Requested-With", "XMLHttpRequest");


    public static ResponseSpecification response = new ResponseSpecBuilder()
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();
}
