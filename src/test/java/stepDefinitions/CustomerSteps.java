package stepDefinitions;

import config.ConfigReader;
import config.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class CustomerSteps {

    private final World world;
    private String base;

    public CustomerSteps(World world) {
        this.world = world;
    }

    @Given("Customer service is available")
    public void customer_service_is_available() {
        base = ConfigReader.get("customer.base.url");
    }

    @When("I add a new customer with default data")
    public void i_add_a_new_customer_with_default_data() {
        Map<String, Object> form = new HashMap<>();
        form.put("customerId", JsonReader.get("default.json", "customerId"));
        form.put("customerName", JsonReader.get("default.json", "customerName"));
        form.put("customerMobile", JsonReader.get("default.json", "customerMobile"));
        form.put("customerEmail", JsonReader.get("default.json", "customerEmail"));
        form.put("customerAddress", JsonReader.get("default.json", "customerAddress"));
        form.put("customerUsername", JsonReader.get("default.json", "customerUsername"));
        form.put("customerPassword", JsonReader.get("default.json", "customerPassword"));

        Response resp = RestUtils.postForm(base + "/addCustomer", form);
        world.setResponse(resp);
    }

    @When("I view customer list")
    public void i_view_customer_list() {
        Response resp = RestUtils.get(base + "/viewCustomerList");
        world.setResponse(resp);
    }

    @When("I view customer by id from {string} in {string}")
    public void i_view_customer_by_id_from_in(String key, String fileName) {
        Object customerId = JsonReader.get(fileName, key);
        Response resp = RestUtils.get(base + "/viewCustomerById/" + customerId);
        world.setResponse(resp);
    }

    @When("I view customer by mobile from {string} in {string}")
    public void i_view_customer_by_mobile_from_in(String key, String fileName) {
        Object mobile = JsonReader.get(fileName, key);
        Response resp = RestUtils.get(base + "/viewCustomerByMobile/" + mobile);
        world.setResponse(resp);
    }

    @When("I delete customer by id from {string} in {string}")
    public void i_delete_customer_by_id_from_in(String key, String fileName) {
        Object customerId = JsonReader.get(fileName, key);
        Response resp = RestUtils.delete(base + "/deleteCustomerById/" + customerId);
        world.setResponse(resp);
    }


    @Then("the response should contain {string}")
    public void the_response_should_contain(String expected) {
        assertTrue(world.getResponse().asString().contains(expected));
    }
}
