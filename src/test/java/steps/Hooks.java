package steps;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
    @Before
    public void setUp() {
    	
        TestBase.WebDriverManager();
    }

    @After
    public void tearDown() {
        TestBase.tearDown();
    }
}
