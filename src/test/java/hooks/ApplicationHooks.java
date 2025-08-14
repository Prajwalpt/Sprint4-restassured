package hooks;

import io.cucumber.java.Before;
import utils.AuthTokenGenerator;

public class ApplicationHooks {

    @Before(order = 0)
    public void beforeAll() {
        // Warm up token retrieval before tests
        AuthTokenGenerator.getToken();
    }
}
