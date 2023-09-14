package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class HomePage {

    final WebDriver driver;

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//a[@href='/login']")
    WebElement login;
    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    WebElement loggedName;
    @FindBy(xpath = "//*[@href='/logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//*[@href='/delete_account']" )
    WebElement deleteAccount;

    //Methods
        String baseUrl = "https://automationexercise.com/";
    public void goToHomePage() {
        driver.get(baseUrl);
    }

    public String notLogged() {
        return login.getText();
    }

    public void clickLogin() {
        login.click();
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public String loggedNameGet(){
        return loggedName.getText();
    }



}
