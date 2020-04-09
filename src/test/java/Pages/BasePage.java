package Pages;

import com.google.common.base.Preconditions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void write(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }
    protected boolean isPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    protected boolean isVisible(By by) {
            return driver.findElement(by).isDisplayed();
    }
    public void moveToElement(WebElement webElement){
        new Actions(driver).moveToElement(webElement).build().perform();
    }
}