package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.Base;

public class Hooks {

    @Before
    public void setup() {
        System.out.println("Initializing Browser before scenario execution...");
        Base.initializeDriver();
    }

    @After
    public void teardown() {
        System.out.println("Closing Browser after scenario execution...");
        Base.tearDown();
    }
}
