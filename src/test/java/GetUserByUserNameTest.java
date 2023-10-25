import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import services.GetUserByUserNameAPI;

import static org.hamcrest.Matchers.equalTo;

public class GetUserByUserNameTest {
    @Test //проверка созданного пользователя   username("dsvewa")
    public void checkCreatedUserByUserName() {
        GetUserByUserNameAPI getUserByUserNameAPI = new GetUserByUserNameAPI();

        getUserByUserNameAPI.getUserByUserName()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(100))
                .body("username", equalTo("dsvewa"))
                .body("userStatus", equalTo(0));
    }

    @Test //проверка отсутствия пользователя   username("svew")
    public void checkErrorResponseStatus() {
        GetUserByUserNameAPI getUserByUserNameAPI = new GetUserByUserNameAPI();

        getUserByUserNameAPI.getUserByUserNameError()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body("code", equalTo(1))
                .body("type", equalTo("error"))
                .body("message", equalTo("User not found"));
    }
}
