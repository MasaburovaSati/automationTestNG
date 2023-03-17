package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilites.Driver;
import utilites.Flow;

public class SauceTest {
    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://saucedemo.com");
        Flow.wait(1000);

    }
        @Test (groups = {"smoke"})
    public void login(){
            Driver.getDriver().get("https://saucedemo.com");
            Flow.wait(1000);
        }


    @Test
    public void logout(){

        Driver.getDriver().get("https://saucedemo.com");
        Flow.wait(1000);
        Driver.getDriver().quit();
    }
}
