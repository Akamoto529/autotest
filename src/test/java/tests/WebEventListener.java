package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.FileOutputStream;

public class WebEventListener extends AbstractWebDriverEventListener {
    FileOutputStream fos;
    public WebEventListener () {
        //fos = new FileOutputStream("C:\\log.txt");
    }
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: '" + url + "'");
    }
    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to:'" + url + "'");
    }
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
    }
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }
    @Override
    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Error occurred: " + error);
    }

}
