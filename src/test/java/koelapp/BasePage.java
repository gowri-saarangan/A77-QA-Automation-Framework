package koelapp;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public BasePage(WebDriver koeldriver){
        driver = koeldriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
    }
    public WebElement findelement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public Boolean findinvisibleelement(By locator){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean findelements(By locator){
        System.out.println(locator);
        List<WebElement> elements = driver.findElements(By.xpath(String.valueOf(locator)));
        return elements.isEmpty();
    }
    public String randomnamegenerator() {
        String listname = RandomStringUtils.randomAlphabetic(7);
        return listname;
    }
}
