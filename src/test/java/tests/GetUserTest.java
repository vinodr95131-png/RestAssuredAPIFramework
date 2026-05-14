package tests;

import listeners.TestListener;
import org.testng.annotations.Listeners;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import utils.APIUtils;
import base.BaseAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class GetUserTest extends BaseAPI {

    @Test
    public void getSingleUserTest() {

        Response response = request
                .when()
                .get("/api/users/2");

        System.out.println(response.asPrettyString());

        response.then().spec(APIUtils.responseSpec200());
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/getUserSchema.json"));

        String firstName = response.jsonPath().getString("data.first_name");

        Assert.assertEquals(firstName, "Janet");
    }
}