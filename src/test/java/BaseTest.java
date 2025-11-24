import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void openbrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    public void closebrowser(){
        driver.quit();
    }

    public void navigationpage() {
        driver.get(url);
    }
    public void emailaddress(String mail) {
        WebElement emailfield = driver.findElement(By.xpath("//input[@type='email']"));
        emailfield.clear();
        emailfield.sendKeys(mail);
    }
        public void password(String pass) {
        WebElement passwordfield = driver.findElement(By.xpath("//input[@type='password']"));
        passwordfield.clear();
        passwordfield.sendKeys(pass);
    }
    public void loginbutton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }



}