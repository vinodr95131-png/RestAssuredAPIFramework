package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class APIUtils {

    public static ResponseSpecification responseSpec200() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpec201() {

        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }
}