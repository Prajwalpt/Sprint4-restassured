package stepDefinitions;

import io.cucumber.java.en.Then;

import static org.testng.Assert.*;

public class CommonSteps {

    private final World world;

    public CommonSteps(World world) {
        this.world = world;
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer code) {
        assertNotNull(world.getResponse());
        assertEquals(world.getResponse().statusCode(), code.intValue());
    }

    @Then("the response body should not be empty")
    public void the_response_body_should_not_be_empty() {
        assertTrue(world.getResponse().getBody().asString().trim().length() > 2);
    }
}
