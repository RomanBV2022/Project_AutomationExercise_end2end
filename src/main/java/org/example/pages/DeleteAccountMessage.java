package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountMessage {
    final WebDriver driver;

    public DeleteAccountMessage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    WebElement accDeleteH2Text;
    @FindBy(xpath = "//*[@data-qa='continue-button']")
    WebElement continueButton;

    public void accDeleteConfirm(){

        String url = driver.getCurrentUrl();
        if(url.equals("https://automationexercise.com/#google_vignette")) {
            driver.get("https://automationexercise.com/delete_account");
            continueButton.click();
        }else {continueButton.click();}
    }

    public String accDeleteMessageTextGet(){
        return accDeleteH2Text.getText();

    }


}
