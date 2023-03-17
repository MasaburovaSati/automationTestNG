package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import pages.StudentPage;
import utilites.Config;
import utilites.Driver;
import utilites.Flow;

public class StudentTest {

@AfterMethod
public void cleanUp(){
    Driver.quitBrowser();
}
    @Test(groups = {"regression"})
    public void verifyingSearchBarIsEnabled() {
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        studentPage.searchInputBox.click();
        String actualText = studentPage.searchInputBox.getAttribute("placeholder");
        String expectedText = "Search";
        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(studentPage.searchInputBox.isEnabled(), "Search bar is not clickable");
    }


    @Test(groups = {"regression"})
    public void verifyingSearchByName() {
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        studentPage.searchInputBox.click();
        String testdata = "Test Student 4 Test 4";
        studentPage.searchInputBox.sendKeys(testdata);
        Flow.wait(500);
        if (studentPage.searchStudentInfoByName.size() > 0) {
            for (WebElement informationOfStudent : studentPage.searchStudentInfoByName) {
                Assert.assertTrue(informationOfStudent.getText().contains(testdata), "Search information by name not found");
            }
        }
    }


    @Test(groups = {"regression"})
    public void verifyingSearchInfoByGroup() {
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        studentPage.searchInputBox.click();
        String testdata = "Bayer-Lehner";
        studentPage.searchInputBox.sendKeys(testdata);
        Flow.wait(500);
        if (studentPage.searchStudentInfoByGroup.size() > 0) {
            for (WebElement informationOfStudent : studentPage.searchStudentInfoByGroup) {
                Assert.assertTrue(informationOfStudent.getText().contains(testdata), "Search information by group not found");
            }
        }
    }

    @Test(groups = {"regression"})
    public void verifyingSearchInfoByNumber() {
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        studentPage.searchInputBox.click();
        String testdata = "44444";
        studentPage.searchInputBox.sendKeys(testdata);
        Flow.wait(500);
        if (studentPage.searchStudentInfoByNumber.size() > 0) {
            for (WebElement informationOfStudent : studentPage.searchStudentInfoByNumber) {
                Assert.assertTrue(informationOfStudent.getText().contains(testdata), "Search information by number not found");
            }
        }
    }

    @Test(groups = {"regression"})
    public void verifyingSearchInfoByEmail() {
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        studentPage.searchInputBox.click();
        String testdata = "test4@gmail.c";
        studentPage.searchInputBox.sendKeys(testdata);
        Flow.wait(500);
        if (studentPage.searchStudentInfoByEmail.size() > 0) {
            for (WebElement informationOfStudent : studentPage.searchStudentInfoByEmail) {
                Assert.assertTrue(informationOfStudent.getText().contains(testdata), "Search information by email not found");
            }
        }
    }
}
















