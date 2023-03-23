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

public class StudentFilterTest {
    @AfterMethod
    public void cleanUp() {
        Driver.quitBrowser();
    }

    @Test(groups = {"regression"})
    public void verifyingSearchFilterBtnIsDisplayed() {
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();


        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        Assert.assertTrue(studentPage.filterBtn.isDisplayed());
    }


    @Test(groups = {"regression"})
    public void verifyingSearchStudentInfoByOnline() {
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        studentPage.filterBtn.click();
        studentPage.studyFormat.click();
        Flow.wait(500);
        studentPage.studyFormatOption.get(0).click();
        studentPage.applyBtn.click();
        String format = "ONLINE";
        Flow.wait(500);
        if (studentPage.searchStudentFormat.size() > 0) {
            for (WebElement informationOfStudent : studentPage.searchStudentFormat) {
                Assert.assertTrue(informationOfStudent.getText().contains(format), "Search information by ONLINE format not found");
            }
        }
    }

    @Test(groups = {"regression"})
    public void verifyingSearchStudentInfoByOffline() {
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        studentPage.filterBtn.click();
        studentPage.studyFormat.click();
        Flow.wait(500);
        studentPage.studyFormatOption.get(1).click();
        studentPage.applyBtn.click();
        String format = "OFFLINE";
        Flow.wait(500);
        if (studentPage.searchStudentFormat.size() > 0) {
            for (WebElement informationOfStudent : studentPage.searchStudentFormat) {
                Assert.assertTrue(informationOfStudent.getText().contains(format), "Search information by OFFLINE format not found");
            }
        }
    }

    @Test(groups = {"regression"})
    public void verifyingSearchStudentFilterByGroup() {
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        studentPage.filterBtn.click();
        studentPage.groupBtn.click();
        Flow.wait(500);
        studentPage.groupList.get(0).click();
        studentPage.applyBtn.click();
        String format = "Ilene South";
        Flow.wait(500);
        if (studentPage.searchStudentInfoByGroup.size() > 0) {
            for (WebElement informationOfStudent : studentPage.searchStudentInfoByGroup) {
                Assert.assertTrue(informationOfStudent.getText().contains(format), "Search information by group format not found");
            }
        }
    }

    @Test(groups = {"regression"})
    public void verifyingFilterResentButton() { //resent filter button not working it is a bug
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        studentPage.filterBtn.click();
        Flow.wait(500);
        studentPage.studyFormat.click();
        Flow.wait(500);
        studentPage.studyFormatOption.get(1).click();
        Flow.wait(500);
        studentPage.resetBtn.click();
        Flow.wait(500);
        studentPage.filterBtn.click();
        Flow.wait(1000);
        studentPage.resetBtn.click();
        Flow.wait(500);
        String format = "OFFLINE";
        if (studentPage.searchStudentFormat.size() > 0) {
            for (WebElement informationOfStudent : studentPage.searchStudentFormat) {
                Assert.assertTrue(informationOfStudent.getText().contains(format), "Search information by OFFLINE format not found");
            }
        }


    }

    @Test(groups = {"regression"})
    public void verifyingXBtn() {
        StudentPage studentPage = new StudentPage();
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        adminPage.sidebarOptions.get(3).click();
        studentPage.filterBtn.click();
        studentPage.studyFormat.click();
        Flow.wait(500);
        studentPage.studyFormatOption.get(0).click();
        studentPage.applyBtn.click();
        Flow.wait(1000);
        Assert.assertTrue(studentPage.xBtn.isDisplayed());
        studentPage.xBtn.click();
        Flow.wait(2000);
        Assert.assertFalse(studentPage.xBtn.isDisplayed());

            }
        }

