package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationBar {
    final WebDriver driver;

    public NavigationBar(WebDriver driver) {
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
    public boolean loginButtonDisplaed(){
        return loginButton.isDisplayed();
    }
    public void clickLogin() {
        Wait<WebDriver> wait;
        wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(5));
        wait.until(d -> loginButton.isDisplayed());
        loginButton.click();
    }
    public String loggedNameGet(){
        return loggedName.getText();
    }
    public void deleteAccount(){
        deleteAccount.click();
    }

    public void clickLogout(){
        logoutButton.click();

    }
    public void deletAccountClick(){
        deleteAccount.click();
        String url = driver.getCurrentUrl();
        if(url.equals("https://automationexercise.com/#google_vignette")) {
            driver.get("https://automationexercise.com/");
            deleteAccount.click();
        }
    }


}
