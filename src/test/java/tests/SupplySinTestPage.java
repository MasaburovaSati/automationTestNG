package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.SupplySinLoginPage;
import utilites.Config;
import utilites.Driver;
import utilites.Flow;

public class SupplySinTestPage {
    SupplySinLoginPage supplySinLoginPage = new SupplySinLoginPage();

    @Test
    public void loginPositive(){
        Driver.getDriver().get(Config.getValue("supplyURL1"));
        supplySinLoginPage.login("codewise@gmail.com", "123123");
        String expectedURL = "https://supplysync.us/dashboard/companies";
        Flow.wait(1500);
        Assert.assertEquals(expectedURL, Driver.getDriver().getCurrentUrl());
    }
    @Test
    public void loginNegative(){
        Driver.getDriver().get(Config.getValue("supplyURL1"));
        supplySinLoginPage.login("random@gmail.com", "123343");
        String errorMessage = supplySinLoginPage.errorMessage.getText();
        String expectedMessage = "Incorrect login and/or password.";
        Flow.wait(1500);
        Assert.assertEquals(expectedMessage, errorMessage );

    }


}
