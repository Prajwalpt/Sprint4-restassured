package utils;

import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class AuthTokenGenerator {

    private static String cachedToken;
    private static long expiryEpochSeconds = 0;

    public static synchronized String getToken() {
        long now = Instant.now().getEpochSecond();
        if (cachedToken != null && now < expiryEpochSeconds - 30) {
            return cachedToken;
        }

        Map<String, String> form = new HashMap<>();
        form.put("grant_type", ConfigReader.get("auth.grant_type"));
        form.put("client_id", ConfigReader.get("auth.client_id"));
        form.put("client_secret", ConfigReader.get("auth.client_secret"));

        Response resp = RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParams(form)
                .post(ConfigReader.get("auth.base.url"))
                .then()
                .statusCode(200)
                .extract().response();

        cachedToken = resp.jsonPath().getString("access_token");
        int expiresIn = resp.jsonPath().getInt("expires_in");
        expiryEpochSeconds = now + expiresIn;

        if (cachedToken == null || cachedToken.isEmpty()) {
            throw new RuntimeException("Failed to obtain access_token");
        }
        return cachedToken;
    }
}
