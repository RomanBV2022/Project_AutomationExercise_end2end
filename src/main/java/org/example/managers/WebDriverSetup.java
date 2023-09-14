package org.example.managers;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverSetup {

        public static WebDriver initializeDriver() {

        String webdriver = System.getProperty("browser");
        switch(webdriver) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                WebDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                WebDriver driver = new EdgeDriver();
                driver.manage().window().maximize();
                return driver;
            }
//            case "safari" -> {
//                WebDriverManager.safaridriver().setup();
//                driver = new SafariDriver();
//                driver.manage().window().maximize();
//                return driver;
//            }
            default -> throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }

}