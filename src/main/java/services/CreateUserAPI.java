package services;

import request.CreateUserRequest;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CreateUserAPI {
    private final String BASE_URL = "https://petstore.swagger.io/v2/";
    private final String CREATE_USER_PATH = "/user";
    private RequestSpecification requestSpecification;


    public CreateUserAPI() {
        requestSpecification = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .log().all();
    }

    public ValidatableResponse createUser(CreateUserRequest user) {
        return given(requestSpecification)
                .body(user)
                .when()
                .post(CREATE_USER_PATH)
                .then()
                .log().all();
    }
}