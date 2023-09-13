package stepDefinitions;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public WebDriver driver;

    @Before
    public static WebDriver initialize() {
        //For use driver in src\\main\\resources\\ uncomment next 4 string

//        System.out.println("Initialize  Web Driver");
//        ChromeOptions ops = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriverNew.exe");
//        WebDriver driver = new ChromeDriver(ops);

        // and comment this next 2 string
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }




}
