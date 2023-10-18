import DTO.CreateUserDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import services.CreateUserAPI;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserDTOTest {
    @Test
    public void checkCreateUser() {
        CreateUserAPI createUserAPI = new CreateUserAPI();
        CreateUserDTO newUserAllFields = CreateUserDTO.builder()
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
                .body("code",equalTo(200))
                .body("type",equalTo("unknown"))
                .body("message",equalTo("300"));
    }
}