package ru.yandex.burgers.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserApi {

    private static final String BASE_URL =
            "https://qa-stellarburgers.education-services.ru";

    public Response createUser(String name, String email, String password) {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body("{"
                        + "\"email\":\"" + email + "\","
                        + "\"password\":\"" + password + "\","
                        + "\"name\":\"" + name + "\""
                        + "}")
                .post("/api/auth/register");
    }

    public void deleteUser(String token) {
        RestAssured
                .given()
                .baseUri(BASE_URL)
                .header("Authorization", token)
                .delete("/api/auth/user");
    }
}