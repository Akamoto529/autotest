package Pages;

import org.openqa.selenium.*;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void write(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected  boolean isDisplayed(By by){
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}