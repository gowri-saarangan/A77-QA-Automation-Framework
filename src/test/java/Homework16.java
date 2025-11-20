import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //navigate to main url
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(@href,'registration')]")).click();

        String registrationpage = "https://qa.koel.app/registration";
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),registrationpage);
        driver.quit();


    }
}
