package pagefactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppBasePage {
    public WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public AppBasePage(WebDriver pfdriver) {

       // WebDriver pagefactorydriver;
        driver = pfdriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
    }
    public String randnamegenerator() {
        String name= RandomStringUtils.randomAlphabetic(7);
        return name;
    }
}
/*public WebElement findElement(WebElement webElement){

    return wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
}*/

