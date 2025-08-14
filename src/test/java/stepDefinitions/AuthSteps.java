package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.AuthTokenGenerator;

import static org.testng.Assert.*;

public class AuthSteps {

    private String token;

    @Given("I request an access token")
    public void i_request_an_access_token() {
        token = AuthTokenGenerator.getToken();
    }

    @Then("I should receive a valid bearer token")
    public void i_should_receive_a_valid_bearer_token() {
        assertNotNull(token);
        assertTrue(token.length() > 20, "Token length should look valid");
    }
}
