package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    final WebDriver driver;

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    WebElement login;
    @FindBy(xpath = "//li[1]/a")
    WebElement homeLink;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    WebElement nameUser;
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    WebElement logOut;
    @FindBy(xpath = "//li[5]/a[@href=\"/delete_account\"]")
    WebElement deleteAccount;
    @FindBy(xpath = "//li/a[@href = '/test_cases']")
    WebElement buttonTestCase;
    @FindBy(xpath = "//li/a[@href = '/products']")
    WebElement buttonProducts;

    //Methods

    public  void goToHomePage() {
        driver.get("http://automationexercise.com");
    }

    public String notLogged() {
        System.out.println(login.getText());
        return login.getText();
    }

    public void clickLogin() {
        if(login.getText().equals("Signup / Login")){
            login.click();
        }
        else if(login.getText().equals("Logout")){
            login.click();
        }
        else {
            System.out .println(login.getText());

        }

    }

    public String getHomeLink() {
       return  homeLink.getAttribute("style");
    }

    public String checkNameUser() {
        return nameUser.getText();
    }
    public void deleteAccount(){
        deleteAccount.click();
    }

    public void clickLogOut() {
        logOut.click();
    }
    public void clickDeleteAccount() {
        deleteAccount.click();
    }
    public void clickProductsPage() {
        productsLink_xpath.click();
    }
    public void clickTestCasesPage() {testCasesLink_xpath.click();}
    public void clickViewProductFirstOnHome() {
        viewProductFirstOnHome_xpath.click();
    }


    public void clickTestCaseButton(){
        buttonTestCase.click();
    }

    public void clickProductsButton(){
        buttonProducts.click();
    }
}
