package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    final WebDriver driver;
    private final String baseUrl = "https://automationexercise.com/login";
    private final String name = "John";

    @FindBy(className = "signup-form")
    WebElement signupForm;
    @FindBy(xpath = "//*[@data-qa='signup-name']")
    WebElement nameInputSignupField;

    @FindBy(xpath = "//*[@data-qa='signup-email']")
    WebElement emailSignupInputField;

    @FindBy(xpath = "//*[@data-qa='signup-button']")
    WebElement signupButton;
    @FindBy(xpath = "//*[@data-qa='login-email']")
    WebElement emailLoginInputField;
    @FindBy(xpath = "//*[@data-qa='login-password']")
    WebElement passwdLLoginInputField;
    @FindBy(xpath = "//*[@data-qa='login-button']")
    WebElement loginButton;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean nameSignupInputFieldDisplayed(){
        return nameInputSignupField.isDisplayed();
    }
    public void nameInput(String name) {
        nameInputSignupField.click();
        nameInputSignupField.sendKeys(name);
    }

    public String inputNameGet() {
        return nameInputSignupField.getText();
    }

    public void emailInputSignupForm(String email) {
        emailSignupInputField.click();
        emailSignupInputField.sendKeys(email);
    }

    public void PasswdLLoginInputField(String passwd) {
        passwdLLoginInputField.click();
        passwdLLoginInputField.sendKeys(passwd);
    }

    public void signupButtonClick() {
        signupButton.submit();
    }

    public String getName() {
        return name;
    }

    public void emailLoginInputField(String email) {
        emailLoginInputField.click();
        emailLoginInputField.sendKeys(email);
    }

    public void loginButtonSubmit(){
        loginButton.submit();
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public boolean signupFormDisplayed(){
        return signupForm.isDisplayed();
    }
}
