package services;

import config.ApiServicePath;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetUserByUserNameAPI {

    public static final String USERNAME = "dsvewa";
    public static final String ERROR_USERNAME = "svew";
    private RequestSpecification requestSpecification;

    public GetUserByUserNameAPI() {
        requestSpecification = given()
                .baseUri(ApiServicePath.baseUrl)
                .contentType(ContentType.JSON)
                .log().all();
    }

    public ValidatableResponse getUserByUserName() {
        return given(requestSpecification)
                .when()
                .get(ApiServicePath.getUserByUserName, USERNAME)
                .then()
                .log().all();
    }

    public ValidatableResponse getUserByUserNameError() {
        return given(requestSpecification)
                .when()
                .get(ApiServicePath.getUserByUserName, ERROR_USERNAME)
                .then()
                .log().all();
    }


}
