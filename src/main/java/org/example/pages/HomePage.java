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
    @FindBy(xpath = "//li[1]/a")
    WebElement homeLink;
    @FindBy(xpath = "//li/a[contains(text(), 'Logged in as')]/b")
    WebElement nameUser;
    @FindBy(xpath = "//a[contains(text(), \"Logout\")]")
    WebElement logOut;


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

    public String getHomeLink() {
       return  homeLink.getAttribute("style");
    }

    public String checkNameUser() {
        return nameUser.getText();
    }

    public void clickLogOut() {
        logOut.click();
    }


    public void tearDown() {
        driver.quit();
    }


}
