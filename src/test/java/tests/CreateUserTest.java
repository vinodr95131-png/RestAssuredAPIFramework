package tests;

import base.BaseAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.CreateUserPayload;
import payloads.CreateUserResponse;

public class CreateUserTest extends BaseAPI {

    @Test
    public void createUserTest() {

        CreateUserPayload payload =
                new CreateUserPayload("Vinod", "QA Engineer");

        Response response = request
                .body(payload)
                .when()
                .post("/api/users");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 201);

        CreateUserResponse responseBody =
                response.as(CreateUserResponse.class);

        Assert.assertEquals(responseBody.getName(), "Vinod");

        Assert.assertEquals(responseBody.getJob(),
                "QA Engineer");
    }
}