import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylist20() throws InterruptedException {
        loginpage();
        Thread.sleep(2000);
        String name1 = randomnamegenerator();
        System.out.println( name1);
        //searchplaylist(name1);
        createplaylist(name1);
        List<WebElement> playlist = driver.findElements(By.xpath("//li[@class='playlist playlist']/a[contains(text(),'"+name1+"')]"));
        System.out.println(playlist);
        Assert.assertTrue(playlist.isEmpty());

    }
}
