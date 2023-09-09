package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    final WebDriver driver;

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//a[@href=\"/login\"]")
    WebElement login;


    //Methods

    public void goToHomePage() {
        driver.get("http://automationexercise.com");
    }

    public String notLogged() {
        return login.getText();
    }

    public void clickLogin() {
        login.click();
    }









    public void tearDown() {
        driver.quit();
    }


}
