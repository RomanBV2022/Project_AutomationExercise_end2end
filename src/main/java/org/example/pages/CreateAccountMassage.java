package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CreateAccountMassage {
    final WebDriver driver;

    public CreateAccountMassage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@data-qa='account-created']")
    WebElement accCreateH2Text;
    @FindBy(xpath = "//*[@data-qa='continue-button']")
    WebElement continueButton;

    public void accCreateConfirm(){
       continueButton.click();
        String url = driver.getCurrentUrl();
        if(!url.equals("https://automationexercise.com/")) {
            driver.get("https://automationexercise.com/account_created");
            continueButton.click();
        }
    }

    public String accCreateMassageTextget(){
        return accCreateH2Text.getText();

    }
}
