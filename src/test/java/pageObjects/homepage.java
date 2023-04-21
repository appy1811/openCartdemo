package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homepage extends basePage {

    public homepage(WebDriver driver){
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement InkMyAccount;

    @FindBy(linkText = "Registetr")
    WebElement InkRegister;

    //Action methods
    public void clickMyAccount(){
        InkMyAccount.click();
    }
    public void clickRegister(){
        InkRegister.click();
    }
}
