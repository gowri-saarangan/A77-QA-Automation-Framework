package pagefactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppLoginPage extends AppBasePage{
    public WebDriver driver;
    @FindBy(xpath = "//input[@type='email']")
    WebElement usernametextbox;
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordtextbox;
    @FindBy(xpath="//button[@type='submit']")
    WebElement logbutton;
    /*By emailfield = new By.ByXPath("//input[@type='email']");
    By passwordfield = new By.ByXPath("//input[@type='password']");
    By submitbtn = new By.ByXPath("//button[@type='submit']");*/

    public AppLoginPage(WebDriver pfdriver){
        super(pfdriver);
        this.driver = pfdriver;
        PageFactory.initElements(driver,this);
    }
    public AppLoginPage setUsernamefield (String email){
        usernametextbox.clear();
        usernametextbox.sendKeys(email);
        return this;
    }

    public AppLoginPage setPasstextfield(String password) {
        passwordtextbox.clear();
        passwordtextbox.sendKeys(password);
        return this;
    }

    public AppLoginPage setapploginbtn() {
        logbutton.click();
        return this;
    }
    public void applogin(String email, String password){
        setUsernamefield(email);
        setPasstextfield(password);
        setapploginbtn();
    }
}
