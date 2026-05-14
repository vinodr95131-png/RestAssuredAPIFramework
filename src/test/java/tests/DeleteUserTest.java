package tests;

import base.BaseAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest extends BaseAPI {

    @Test
    public void deleteUserTest() {

        Response response = request
                .when()
                .delete("/api/users/2");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 204);
    }
}