package services;

import config.ApiServicePath;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import request.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class CreateUserAPI {

    private RequestSpecification requestSpecification;


    public CreateUserAPI() {
        requestSpecification = given()
                .baseUri(ApiServicePath.baseUrl)
                .contentType(ContentType.JSON)
                .log().all();
    }

    public ValidatableResponse createUser(CreateUserRequest user) {
        return given(requestSpecification)
                .body(user)
                .when()
                .post(ApiServicePath.createUser)
                .then()
                .log().all();
    }
}