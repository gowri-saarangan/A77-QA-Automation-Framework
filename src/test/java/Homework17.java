import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.random.RandomGeneratorFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;



public class Homework17 extends BaseTest{
    @Test
    public void userlogin() throws InterruptedException {

    navigationpage();
    emailaddress("gowri.saarangan@testpro.io");
    password("iVRbJcck");
    loginbutton();
Thread.sleep(2000);
    //String url1 = "//div[@class = 'heading-wrapper']/h1/span/strong";//https://qa.koel.app/#!/home";
   //     String searchresult = driver.findElement(By.xpath("//div[@class = 'heading-wrapper']/h1/span/strong"))
    //    Assert.assertEquals(searchresult, url1);

      searchasong();
      //WebElement expectedresult = "//div[@class = 'heading-wrapper']/h1/span/strong";
      //WebElement searchresult = driver.findElement(By.xpath("//div[@class = 'heading-wrapper']/h1/span/strong"));
      //  Assert.assertNotNull(searchresult);
        driver.findElement(By.xpath("//button[@data-test = 'view-all-songs-btn']")).click();
        WebElement firstsong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]"));
        Assert.assertNotNull(firstsong);
        firstsong.click();
driver.findElement(By.xpath("//button[@class='btn-add-to']")).click();
//WebElement parentelement = driver.findElement(By.xpath("//*[@id='songsWrapper']/header/div[3]/div"));
       Thread.sleep(2000);
        //Actions  actiontoperform =new Actions(driver);
       //actiontoperform.moveToElement(driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"))).perform();
      //  new WebDriverWait(driver, Duration.ofSeconds(5));
driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]")).click();
//WebElement playlistname = driver.findElement(By.linkText("Gowri"));
//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
//actiontoperform.moveToElement(playlistname).click().perform();

        Thread.sleep(5000);

        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//WebElement popup = wait.until(ExpectedCondition.visibility)
       // Alert alertmessage = driver.switchTo().alert();
       // String text =alertmessage.getText();
String text = driver.findElement(By.xpath("//div[@class='alertify-logs top right']/div")).getText();
        Assert.assertEquals(text,"Added 1 song into \"Gowri.\"");


    }


}
