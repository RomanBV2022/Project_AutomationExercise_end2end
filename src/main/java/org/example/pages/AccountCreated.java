package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AccountCreated {


    final WebDriver driver;

    public AccountCreated(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//h2[@data-qa=\"account-created\"]/b")
    WebElement accountCreated;
    @FindBy(xpath = "//a[@data-qa=\"continue-button\"]")
    WebElement buttonContinue;
    @FindBy(xpath = "//header[@id=\"header\"]//li[10]//b")
    WebElement loggedUser;
    @FindBy(xpath = "//header[@id=\"header\"]//li[1]")
    WebElement getHomePage;
    @FindBy(xpath = "//div[@id=\"dismiss-button\"]")
    WebElement dismissAdd;





    public String confirmAccountCreated() {
       return accountCreated.getText();
    }

    public void clickButtonContinue() {
        buttonContinue.click();
    }

    public  String showLoggedUser() {
        return loggedUser.getText();
    }

    public String showHomePage() {
        return getHomePage.getText();
    }

    public void clickDismissAdd() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (driver.getPageSource()!= "https://automationexercise.com/") {
            driver.get("https://automationexercise.com/");
        }

    }

}
