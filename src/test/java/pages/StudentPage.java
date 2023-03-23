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
    public WebElement searchInputBox;

    @FindBy(xpath = "//table//tr/td[2]")
    public List<WebElement> searchStudentInfoByName;

    @FindBy(xpath = "//table//tr/td[3]")
    public List<WebElement> searchStudentInfoByGroup;

    @FindBy(xpath = "//table//tr/td[5]")
    public List<WebElement> searchStudentInfoByNumber;

    @FindBy(xpath = "//table//tr/td[6]")
    public List<WebElement> searchStudentInfoByEmail;

    @FindBy (xpath = "//h2/../div/div/button[2]")
    public WebElement filterBtn;

    @FindBy (id = "mui-component-select-studyFormat")
    public WebElement studyFormat;

    @FindBy (xpath = "//ul[@role='listbox']/li")
    public List<WebElement> studyFormatOption;

    @FindBy (id = "mui-component-select-groupId")
    public WebElement groupBtn;

    @FindBy (xpath = "//ul/li[@role='option']")
    public List<WebElement> groupList;

    @FindBy (xpath = "(//h2/../div/button)[4]")
    public WebElement applyBtn;

    @FindBy (xpath = "(//h2/../div/button)[3]")
    public WebElement resetBtn;

    @FindBy(xpath = "//table//tr/td[4]")
    public List<WebElement> searchStudentFormat;

    @FindBy (xpath = "//h2/../div/div/button[3]")
    public WebElement xBtn;








}


