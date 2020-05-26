package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

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
        System.setProperty("webdriver.chrome.logfile", "D:\\chromedriver.log");
        LoggingPreferences logs = new LoggingPreferences();
        //logs.enable(LogType.BROWSER, Level.WARNING);
        //logs.enable(LogType.CLIENT, Level.SEVERE);
        //logs.enable(LogType.DRIVER, Level.SEVERE);
        //logs.enable(LogType.PERFORMANCE, Level.WARNING);
        logs.enable(LogType.PROFILER, Level.WARNING);
        //logs.enable(LogType.SERVER, Level.WARNING);
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, logs);
        driver = new ChromeDriver(options);
        baseUrl = "https://ok.ru/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    public void stop() {
        driver.quit();
    }
}