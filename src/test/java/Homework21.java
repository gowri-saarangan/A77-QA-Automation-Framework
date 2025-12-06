import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() throws InterruptedException {
        loginpage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='avatar']")));
        String name1 = randomnamegenerator();
        System.out.println( name1);
        createrenameplaylist(name1);
        String name2 = randomnamegenerator();
        System.out.println( name2);
        renamingplaylist(name2,name1);
        List<WebElement> oldplylistname =driver.findElements(By.xpath("//li[@class='playlist playlist']/a[contains(text(),'" + name1 + "')]"));
        Assert.assertTrue(oldplylistname.isEmpty());
    }

}
