import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

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
      WebElement searchresult = driver.findElement(By.xpath("//div[@class = 'heading-wrapper']/h1/span/strong"));
        Assert.assertNotNull(searchresult);

    }

}
