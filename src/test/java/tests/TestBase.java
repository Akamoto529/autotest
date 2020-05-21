package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private String baseUrl;
    protected WebDriver driver;

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    public void stop() {
        driver.quit();
    }
}