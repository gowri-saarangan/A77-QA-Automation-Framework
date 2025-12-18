package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AppPlaylistPage extends AppBasePage{
    public WebDriver driver;
    public AppPlaylistPage(WebDriver pfdriver) {
        super(pfdriver);
        this.driver = pfdriver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//img[@class='avatar']")
    WebElement avatarimage;
    @FindBy(xpath = "//i[@data-testid='sidebar-create-playlist-btn']")
    WebElement createplylistbtn;
    @FindBy(xpath = "//li[@data-testid='playlist-context-menu-create-simple']")
    WebElement plylistmenu;
    @FindBy(xpath = "//*[@id='playlists']/form/input")
    WebElement inputform;
    @FindBy(xpath = "//div[@class='alertify-logs top right']/div")
    WebElement alertmsg;
    @FindBy(xpath = "//li[@class='playlist playlist editing']//input[@name = 'name']")
    WebElement playlistedit;
    @FindBy(xpath = "//button[@class='del btn-delete-playlist']")
    WebElement deleteplaylist;
   // @FindBy(xpath = )
    //By renplylistname = new By.ByXPath("//li[@class='playlist playlist']/a[contains(text(),'" + newname + "')]");


    public boolean avatarisdisplayed(){

        boolean avatarimage1 = avatarimage.isDisplayed();
        return avatarimage1;
    }
    public void createanewplaylist(String plylistname) throws InterruptedException {
        System.out.println(plylistname);
       WebElement newplylist = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(createplylistbtn));
                newplylist.click();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(plylistmenu)).click();
        WebElement createplaylstname = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(inputform));
        createplaylstname.clear();
        createplaylstname.sendKeys(plylistname);
        createplaylstname.sendKeys(Keys.ENTER);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']/a[contains(text(),'" + plylistname + "')]")));
        // findelement(crtplylistname);
        String gettext = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(alertmsg)).getText();
        System.out.println(gettext);
        Assert.assertEquals(gettext,"Created playlist \""+plylistname+".\"");
        //Boolean createmsg = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']/div")));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(alertmsg));
    }
    public void playlistrenaming(String newname, String oldname) {
        String oldplylistname = oldname;
        By crtplylistname = new By.ByXPath("//li[@class='playlist playlist']/a[contains(text(),'" + oldplylistname + "')]");
        System.out.println(oldplylistname);
        System.out.println(crtplylistname);
        //Actions action = new Actions(driver);
        WebElement oldplaylistname = wait.until(ExpectedConditions.visibilityOfElementLocated(crtplylistname));
        //driver.findElement(By.xpath("//li[@class='playlist playlist']//a[contains(text(),\"" +oldname+ "\")]"));
        action.doubleClick(oldplaylistname).perform();
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement  editbox = wait.until(ExpectedConditions.visibilityOf(playlistedit));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist editing']//input[@name = 'name']")));
        editbox.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        editbox.sendKeys(newname);
        editbox.sendKeys(Keys.ENTER);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']/a[contains(text(),'" + newname + "')]")));
        //findelement(renplylistname);
        String text = wait.until(ExpectedConditions.visibilityOf(alertmsg)).getText();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']/div"))).getText();
        Assert.assertEquals(text,"Updated playlist \""+newname+".\"");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(alertmsg));

    }
    public void deleteplaylist(String playlist) throws InterruptedException {
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(deleteplaylist)).click();
        //driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']")).click();
        String text = wait.until(ExpectedConditions.visibilityOf(alertmsg)).getText();
        //String text = driver.findElement(By.xpath("//div[@class='alertify-logs top right']/div")).getText();
        Assert.assertEquals(text,"Deleted playlist \""+playlist+".\"");
    }
  /* public String oldplylistname;
    //String newname;
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
    public static boolean avatardisplayed(){

        return  findelement(avatarimg).isDisplayed();
    }

    public  void createanewplaylist(String plylistname) throws InterruptedException {
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
}
