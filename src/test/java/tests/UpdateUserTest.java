package tests;

import base.BaseAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.CreateUserPayload;

public class UpdateUserTest extends BaseAPI {

    @Test
    public void updateUserTest() {

        CreateUserPayload payload =
                new CreateUserPayload("Vinod Updated", "Senior QA");

        Response response = request
                .body(payload)
                .when()
                .put("/api/users/2");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        String updatedName =
                response.jsonPath().getString("name");

        Assert.assertEquals(updatedName,
                "Vinod Updated");
    }
}