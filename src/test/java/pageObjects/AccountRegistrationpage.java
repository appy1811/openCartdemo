package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationpage extends basePage{

    public AccountRegistrationpage(WebDriver driver){
        super(driver);
    }

    //Elements
    @FindBy(name = "First Name")
    WebElement txtFirstName;

    @FindBy(name = "Last Name")
    WebElement txtLastName;

    @FindBy(name = "E-Mail")
    WebElement txtEMail;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(name = "agree")
    WebElement chkdPolicy;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btncontinue;

    @FindBy(xpath = "//hi[normalize-space()='Your Account Has Been Created']")
    WebElement msgconfirmation;

    public void setFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }
         public void setLastName(String lname) {
            txtFirstName.sendKeys(lname);
    }
    public void setEMail(String email) {

        txtFirstName.sendKeys(email);
    }
    public void setPassword(String pwd) {

        txtFirstName.sendKeys(pwd);
    }
    public void setPrivacyPolicy() {
        chkdPolicy.click();
    }
    public void clickcontinue(){
        btncontinue.click();
    }
    public String getConfirmationMsg(){
        try{
            return (msgconfirmation.getText());
        }
        catch (Exception e){
            return (e.getMessage());
        }
    }
}

