package koelapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageapp extends BasePage{
    public LoginPageapp(WebDriver koeldriver) {
        super(koeldriver);
    }
    //locators
    By emailfield = new By.ByXPath("//input[@type='email']");
    By passwordfield = new By.ByXPath("//input[@type='password']");
    By submitbtn = new By.ByXPath("//button[@type='submit']");

    public void setEmailfield (String email){
        findelement(emailfield).clear();
        findelement(emailfield).sendKeys(email);
    }

    public void setPasswordfield(String password) {
        findelement(passwordfield).clear();
        findelement(passwordfield).sendKeys(password);
    }

    public void setSubmitbtn() {
        findelement(submitbtn).click();
    }
    public void login(String email, String password){
        setEmailfield(email);
        setPasswordfield(password);
        setSubmitbtn();
    }

}
