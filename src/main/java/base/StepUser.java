package base;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static base.ApiUrl.*;
import static io.restassured.RestAssured.given;

public class StepUser extends DataUser {
    public static User dataUser() {
        return new User(RANDOM_NAME, RANDOM_EMAIL, PASSWORD);
    }

    @Step ("Создание пользователя")
    public Response createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(user)
                .when()
                .post(USER);
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken) {
        given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .when()
                .header("Authorization", accessToken)
                .delete(DELETE_USER)
                .then();
    }
}