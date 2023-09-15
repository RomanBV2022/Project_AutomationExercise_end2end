package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class TestBase {
    public WebDriver driver;


    public static WebDriver initialize() {
        System.out.println("Initialize  Web Driver");
        ChromeOptions ops = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriverNew.exe");
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }


    public void teardown() {
        driver.quit();
    }


}
