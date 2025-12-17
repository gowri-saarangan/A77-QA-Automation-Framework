package koelapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Duration;
import java.util.List;

public class playlistpage extends BasePage{
    public playlistpage(WebDriver koeldriver) {
        super(koeldriver);
           }


   public String oldplylistname;
    String newname;
    //locators
    By avatarimg = new By.ByXPath("//img[@class='avatar']");
    By createplylistbtn = new By.ByXPath("//i[@data-testid='sidebar-create-playlist-btn']");
    By plylistmenu = new By.ByXPath("//li[@data-testid='playlist-context-menu-create-simple']");
    By inputform = new By.ByXPath("//*[@id='playlists']/form/input");

    //By crtplylistname = new By.ByXPath("//li[@class='playlist playlist']/a[contains(text(),'" + oldplylistname + "')]");
    By alertmsg = new By.ByXPath("//div[@class='alertify-logs top right']/div");
    By playlistedit = new By.ByXPath("//li[@class='playlist playlist editing']//input[@name = 'name']");

    By renplylistname = new By.ByXPath("//li[@class='playlist playlist']/a[contains(text(),'" + newname + "')]");
    //By alertmsggone = new By.ByXPath("//div[@class='alertify-logs top right']/div");
  /*  public static boolean avatardisplayed(){

        return  findelement(avatarimg).isDisplayed();
    }

    public static void createrenewplaylist(String plylistname) throws InterruptedException {
        System.out.println(plylistname);
        findelement(createplylistbtn).click();
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click();
        findelement(plylistmenu).click();
        WebElement createplaylstname = findelement(inputform);
        createplaylstname.clear();
        createplaylstname.sendKeys(plylistname);
        createplaylstname.sendKeys(Keys.ENTER);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']/a[contains(text(),'" + plylistname + "')]")));
       // findelement(crtplylistname);
        String gettext = findelement(alertmsg).getText();
        System.out.println(gettext);
        Assert.assertEquals(gettext,"Created playlist \""+plylistname+".\"");
        //Boolean createmsg = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']/div")));
        findinvisibleelement(alertmsg);
    }


    public static void playlistrename(String newname, String oldname) {
        oldplylistname = oldname;
        By crtplylistname = new By.ByXPath("//li[@class='playlist playlist']/a[contains(text(),'" + oldplylistname + "')]");
        System.out.println(oldplylistname);
        System.out.println(crtplylistname);
        //Actions action = new Actions(driver);
        WebElement oldplaylistname = findelement(crtplylistname);
                //driver.findElement(By.xpath("//li[@class='playlist playlist']//a[contains(text(),\"" +oldname+ "\")]"));
        action.doubleClick(oldplaylistname).perform();
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement  editbox = findelement(playlistedit);
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist editing']//input[@name = 'name']")));
        editbox.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        editbox.sendKeys(newname);
        editbox.sendKeys(Keys.ENTER);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']/a[contains(text(),'" + newname + "')]")));
        //findelement(renplylistname);
        String text = findelement(alertmsg).getText();
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']/div"))).getText();
        Assert.assertEquals(text,"Updated playlist \""+newname+".\"");

    }*/
   /* public void listisempty(String oldname) throws InterruptedException{
        oldplylistname =oldname;
        By crtplylistname = new By.ByXPath("//li[@class='playlist playlist']/a[contains(text(),'" + oldplylistname + "')]");
        System.out.println(findelements(crtplylistname));

        Assert.assertTrue(findelements(crtplylistname));
    }*/

    
}
