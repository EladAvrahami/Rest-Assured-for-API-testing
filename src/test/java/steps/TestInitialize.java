package steps;

import io.cucumber.java.Before;
import utilities.RestAssuredExtension;

public class TestInitialize {

    //responsible invoking my method
    @Before
    public void TestSetup(){
        //
        RestAssuredExtension restAssuredExtension=new RestAssuredExtension();
    }
}
