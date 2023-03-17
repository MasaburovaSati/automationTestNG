package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.Driver;

import java.util.List;

public class StudentPage {


    public StudentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div/input[1]")
    public WebElement searchBtn;

    @FindBy(xpath = "//table//tr/td[2]")
    public List<WebElement> searchStudentInfoByName;

    @FindBy(xpath = "//table//tr/td[3]")
    public List<WebElement> searchStudentInfoByGroup;

    @FindBy(xpath = "//table//tr/td[5]")
    public List<WebElement> searchStudentInfoByNumber;

    @FindBy(xpath = "//table//tr/td[6]")
    public List<WebElement> searchStudentInfoByEmail;





}


