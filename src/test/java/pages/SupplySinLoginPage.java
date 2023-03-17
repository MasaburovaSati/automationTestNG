package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.Driver;

public class SupplySinLoginPage {

    public SupplySinLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="input")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement passwordBtn;

    @FindBy(tagName = "button")
    public WebElement signInBtn;

    @FindBy(tagName = "p")
    public WebElement errorMessage;


    public void login(String email, String password) {
        userName.sendKeys(email);
        passwordBtn.sendKeys(password);
        signInBtn.click();
    }


}
