package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@data-qa='signup-name']")
    WebElement nameInputField;

    @FindBy(xpath = "//*[@data-qa='signup-email']")
    WebElement emailInputField;

    @FindBy(xpath = "//*[@data-qa='signup-button']" )
    WebElement signupButton;



    public void nameInput(){
        String name;
        name = "John";
        nameInputField.click();
        nameInputField.sendKeys(name);
    }
    public String inputedNameGet(){
        return nameInputField.getText();
    }
    public void emailInput(){
        emailInputField.click();
        emailInputField.sendKeys("john321@mail.com");
    }
    public void signupButtonClick(){
        signupButton.click();
    }

}
