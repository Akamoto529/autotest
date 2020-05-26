package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.FileWriter;
import java.io.IOException;

public class WebEventListener extends AbstractWebDriverEventListener {
    FileWriter fw;
    public WebEventListener () {
        try {
            fw = new FileWriter("log.txt", false);
        } catch(IOException e){}
    }
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        writeLine("Before navigating to: '" + url + "'");
    }
    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        writeLine("Navigated to:'" + url + "'");
    }
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        writeLine("Trying to click on: " + element.toString());
    }
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        writeLine("Clicked on: " + element.toString());
    }
    @Override
    public void onException(Throwable error, WebDriver driver) {
        writeLine("Error occurred: " + error);
    }
    private void writeLine(String str){
        try{
            fw.write(str);
            fw.append('\n');
            fw.flush();
        }catch(IOException e){}
    }
}
