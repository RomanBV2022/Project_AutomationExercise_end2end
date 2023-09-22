package org.example.pages;

import io.cucumber.java.zh_cn.而且;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    final WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//input[@name='name']")
    WebElement name;
    @FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
    WebElement signUpEmail;
    @FindBy(xpath = "//button[@data-qa=\"signup-button\"]")
    WebElement signUpButton;
    @FindBy(xpath = "//input[@data-qa=\"login-email\"]")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa=\"login-password\"]")
    WebElement password;
    @FindBy(xpath = "//button[@data-qa=\"login-button\"]")
    WebElement loginButton;
    @FindBy(xpath = "//a[@href='/login']")
    WebElement login;

    //Methods
    public void createUser(String name, String email) {
        this.name.sendKeys(name);
        signUpEmail.sendKeys(email);
    }

    public void clickSignUp() {
        signUpButton.click();

    }

    public void logIn(String email, String password) {
        loginEmail.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();

    }
    public String notLogged() {
        return login.getText();
    }

}
