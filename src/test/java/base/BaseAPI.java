package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import utils.TokenManager;

public class BaseAPI {

    protected RequestSpecification request;

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://reqres.in";

        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres_b1a5f03d28164241a6255e221e8a2817")
                .header("Authorization",
                        "Bearer " + TokenManager.getToken());
    }
}