package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderComponent{
    final WebDriver driver;

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@href='/login']")
    WebElement loginButton;
    @FindBy(xpath = "//*[@href='/logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//*[@href='/delete_account']" )
    WebElement deleteAccount;
    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[5]/a")
    WebElement loggedText;
    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
        WebElement loggedName;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a")
    WebElement loggedLink;

    public void loginButtonDisplaedWait(){
        Wait<WebDriver> wait;
        wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(5));
        wait.until(d -> loginButton.isDisplayed());
    }

    public void clickLogin() {

        loginButton.click();
    }
    public String loggedNameGet(){
        return loggedName.getText();
    }
    public void deleteAccount(){
        deleteAccount.click();
    }

}
