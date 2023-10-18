import org.junit.jupiter.api.Assertions;
import request.CreateUserRequest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import response.CreateUserResponse;
import services.CreateUserAPI;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserRequestTest {
    @Test
    public void checkCreateUserAllFields() {
        CreateUserAPI createUserAPI = new CreateUserAPI();
        CreateUserRequest newUserAllFields = CreateUserRequest.builder()
                .id(300l)
                .userStatus(100l)
                .phone("+84348393")
                .email("fdserfd@test.com")
                .username("dsvew")
                .firstName("Test")
                .lastName("Terrst")
                .password("sdgs4")
                .build();
        createUserAPI.createUser(newUserAllFields)
                .statusCode(HttpStatus.SC_OK)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("300"));
    }

    @Test
    public void checkCreateUserTwoFields() {
        CreateUserAPI createUserAPI = new CreateUserAPI();
        CreateUserRequest newUserAllFields = CreateUserRequest.builder()
                .id(100l)
                .username("dsvewa")
                .build();
        createUserAPI.createUser(newUserAllFields)
                .statusCode(HttpStatus.SC_OK);

        int actualCode = createUserAPI.createUser(newUserAllFields).extract().body().jsonPath().get("code");
        int expectedCode = 200;

        String actualMessage = createUserAPI.createUser(newUserAllFields).extract().body().jsonPath().get("message");
        String expectedMessage = "100";

        String actualType = createUserAPI.createUser(newUserAllFields).extract().body().jsonPath().get("type");
        String expectedType = "unknown";

    }

    @Test
    public void checkCreateUserWithoutFields() {
        CreateUserAPI createUserAPI = new CreateUserAPI();
        CreateUserRequest newUserAllFields = CreateUserRequest.builder()
                .build();
        createUserAPI.createUser(newUserAllFields)
                .statusCode(HttpStatus.SC_OK);


        CreateUserResponse createUserResponse = createUserAPI.createUser(newUserAllFields).extract().body().as(CreateUserResponse.class);
        Assertions.assertEquals(200, createUserResponse.getCode());
        Assertions.assertEquals("unknown", createUserResponse.getType());
        Assertions.assertEquals("0", createUserResponse.getMessage());
    }
}