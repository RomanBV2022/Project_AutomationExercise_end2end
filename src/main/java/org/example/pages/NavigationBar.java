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
    @FindBy(xpath = "//*[@href='/login']")
    WebElement loginButtonLink;
    @FindBy(xpath = "//*[@href='/logout']")
    WebElement logoutButtonLink;
    @FindBy(xpath = "//*[@href='/delete_account']")
    WebElement deleteAccountLink;
    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[5]/a")
    WebElement loggedText;
    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    WebElement loggedName;
    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a")
    WebElement loggedLink;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public void loginButtonDisplaedWait() {
//        Wait<WebDriver> wait;
//        wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(5));
//        wait.until(d -> loginButton.isDisplayed());
//    }

    public boolean loginButtonDisplaed() {
        return loginButtonLink.isDisplayed();
    }

    public void clickLogin() {
        Wait<WebDriver> wait;
        wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(5));
        wait.until(d -> loginButtonLink.isDisplayed());
        loginButtonLink.click();
    }

    public String loggedNameGet() {
        return loggedName.getText();
    }

    public void deleteAccount() {
        deleteAccountLink.click();
    }


    public void clickLogout() {

        Wait<WebDriver> wait;
        wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(5));
        wait.until(d -> logoutButtonLink.isDisplayed());

        logoutButtonLink.click();

    }

    public void deleteAccountClick() {
        deleteAccountLink.click();
        String url = driver.getCurrentUrl();
        if (url.equals("https://automationexercise.com/#google_vignette")) {
            driver.get("https://automationexercise.com/");
            deleteAccountLink.click();
        }
    }


}
