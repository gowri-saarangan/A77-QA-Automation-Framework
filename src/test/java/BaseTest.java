import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedCondition.*;

public class BaseTest {

    public WebDriver driver;
    public String url ;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BasURL"})
    public void openbrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
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


    public void searchasong() {
        WebElement searchsong = driver.findElement(By.xpath("//input[@type = 'search']"));
        searchsong.clear();
        searchsong.sendKeys("tunnel of lights");
    }

    public void viewallsongs() {
        driver.findElement(By.xpath("//button[@data-test = 'view-all-songs-btn']")).click();
    }

    public void clickfirstsong() {
        Actions action = new Actions(driver);
      WebElement firstsong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]"));
       //firstsong.click();
        action.doubleClick(firstsong).perform();
    }

    public void soundbarisdisplay() {
        WebElement visualizer = driver.findElement(By.xpath("//button[@data-testid='toggle-visualizer-btn']"));
        Assert.assertNotNull(visualizer);
    }

    public void playimmediatenextsong() throws InterruptedException {
        Actions action = new Actions(driver);
        //driver.findElement(By.xpath("//span[@class='album-thumb-wrapper']")).click();

        WebElement nextbutton =  driver.findElement(By.xpath("//div[@class='side player-controls']/i[2]"));
        // //driver.findElement(By.xpath("//*[@id='mainFooter']/div/i[2]"));
        Thread.sleep(5000);
        //nextbutton.click();

        //Assert.assertNotNull(nextbutton);
        action.doubleClick(nextbutton).perform();

        Thread.sleep(5000);
     // WebElement nextsongbtn=  driver.findElement(By.cssSelector("#mainFooter > div.side.player-controls > i.next.fa.fa-step-forward.control"));
     //   action.click(nextsongbtn).perform();
     // WebElement next = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/i[2]"));
      //  if (next.isEnabled()) {
       //     action.doubleClick(next).perform();
       // }


    }

    public void pausebtnisdisplayed() {
        WebElement pausebtn = driver.findElement(By.xpath("//*[@id='mainFooter']/div/span//span[@data-testid='pause-btn']"));
        Assert.assertNotNull(pausebtn);
    }
    public void clickfirstsongbymediacontrol() {
        //Actions action = new Actions(driver);
        WebElement firstsong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]"));
        firstsong.click();
        //action.doubleClick(firstsong).perform();
    }
    public void clickplay() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // WebElement wrapper = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainFooter']/div[1]/span[1]//span[@data-testid='play-btn']")));
        WebElement wrapper = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='album-thumb-wrapper']")));
        //WebElement wrapper = driver.findElement(By.xpath("//span[@class='album-thumb-wrapper']"));
        wrapper.click();
        driver.findElement(By.xpath("//*[@id='mainFooter']/div/span//span[@data-testid='play-btn']")).click();
    }

    public void nextsongselected() {
        Actions action = new Actions(driver);
        WebElement firstsong = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[2]"));
        //firstsong.click();
        action.doubleClick(firstsong).perform();
    }

    public void nextsongbymediacontrol() {
       // WebElement parentdiv = driver.findElement(By.id("mainFooter"));
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='side player-controls']"));
        Assert.assertNotNull(items);
        if (items.size()>=3){
        WebElement firstitem = items.get(0);
        WebElement seconditem = items.get(1);
        WebElement thirditem = items.get(2);
        System.out.println("third item:" + thirditem.getText());
        thirditem.click();
        }
    }

    public void loginpage() {
        navigationpage();
        emailaddress("gowri.saarangan@testpro.io");
        password("iVRbJcck");
        loginbutton();
    }

    public String randomnamegenerator() {
        String name= RandomStringUtils.randomAlphabetic(7);
        return name;
    }

    public void searchplaylist(String rdnplaylistname) {
        System.out.println(rdnplaylistname);
        System.out.println("//li[@class='playlist playlist']/a[contains(text(),'"+rdnplaylistname+"')]");
        boolean exists;
        try {
           driver.findElement(By.xpath("//li[@class='playlist playlist']/a[contains(text(),'" + rdnplaylistname + "')]"));
            exists = true;
        }catch (NoSuchElementException e){
            exists = false;
            System.out.println(exists);
        }
        if(!exists) {
            System.out.println(rdnplaylistname);
            //createplaylist(rdnplaylistname);

        }
        else {
            driver.findElement(By.xpath("//li[@class='playlist playlist']/a[contains(text(),'" + rdnplaylistname + "')]")).click();
            //delplaylistname(rdnplaylistname);
        }
    }

    public void createplaylist(String plylistname) throws InterruptedException {
        System.out.println(plylistname);
        driver.findElement(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']")).click();
        Thread.sleep(2000);
        WebElement createplylstname = driver.findElement(By.xpath("//*[@id='playlists']/form/input"));
        createplylstname.clear();
        //System.out.println("I am here" +plylistname);
        createplylstname.sendKeys(plylistname);
        createplylstname.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//li[@class='playlist playlist']/a[contains(text(),'" + plylistname + "')]")).click();
        Thread.sleep(5000);
        delplaylistname(plylistname);

    }

    public void delplaylistname(String playlist) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']")).click();
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//div[@class='alertify-logs top right']/div")).getText();
        Assert.assertEquals(text,"Deleted playlist \""+playlist+".\"");
    }
}