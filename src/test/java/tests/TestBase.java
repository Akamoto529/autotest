package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private String baseUrl;
    protected WebDriver driver;
    EventFiringWebDriver e_driver;
    private WebEventListener eventListener;

    @BeforeEach
    public void setUp() throws Exception {
        init();
    }

    @AfterEach
    public void tearDown() throws Exception {
        stop();
    }

    public void init() {
        driver = new ChromeDriver();
        baseUrl = "https://ok.ru/";
        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        e_driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        e_driver.get(baseUrl + "/");
    }

    public void stop() {
        driver.quit();
    }
}