package utils;

import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestUtils {

    private static RequestSpecification baseSpecWithAuth() {
        String token = AuthTokenGenerator.getToken();
        return new RequestSpecBuilder()
                .setAccept(ConfigReader.get("accept"))
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }

    public static Response get(String url) {
        return RestAssured.given()
                .spec(baseSpecWithAuth())
                .log().all()
                .get(url)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response delete(String url) {
        return RestAssured.given()
                .spec(baseSpecWithAuth())
                .log().all()
                .delete(url)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response postForm(String url, Map<String, ?> formParams) {
        return RestAssured.given()
                .spec(baseSpecWithAuth())
                .contentType(ConfigReader.get("contentType"))
                .formParams(formParams)
                .log().all()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }
}
