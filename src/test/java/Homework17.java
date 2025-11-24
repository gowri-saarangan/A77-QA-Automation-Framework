import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void userlogin() throws InterruptedException {

    navigationpage();
    emailaddress("gowri.saarangan@testpro.io");
    password("iVRbJcck");
    loginbutton();
Thread.sleep(2000);
    String url1 = "https://qa.koel.app/#!/home";
        Assert.assertEquals(driver.getCurrentUrl(), url1);

    }

}
