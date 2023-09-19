package org.example.pages;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    private final String baseUrl = "https://automationexercise.com/";
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage() {
        driver.get(baseUrl);
    }
    public String urlCurrentGet(){
        return driver.getCurrentUrl();
    }
    public String getBaseUrl(){
        return baseUrl;
    }

}








