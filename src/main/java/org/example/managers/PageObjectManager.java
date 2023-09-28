package org.example.managers;

import org.example.pages.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SignUpPage signUpPage;
    private AccountCreated accountCreated;
    private ProductsPage productsPage;
    private CartPage cartPage;



    public PageObjectManager(HomePage homePage) {
        this.homePage = homePage;
    }
    public PageObjectManager(LoginPage loginPage) {
        this.loginPage = loginPage;
    }
    public PageObjectManager(SignUpPage signUpPage) {
        this.signUpPage= signUpPage;
    }
    public PageObjectManager(AccountCreated accountCreated) {
        this.accountCreated = accountCreated;
    }

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
    public LoginPage getLoginPage() {
        return (loginPage==null) ? loginPage = new LoginPage(driver) : loginPage;
    }
    public ProductsPage getProductsPage() {
        return (productsPage==null) ? productsPage = new ProductsPage(driver) : productsPage;}

    public SignUpPage getSignUpPage() {
        return (signUpPage == null) ? signUpPage = new SignUpPage(driver) : signUpPage;
    }
    public  AccountCreated getAccountCreated() {
        return (accountCreated == null) ? accountCreated= new AccountCreated(driver) : accountCreated;
    }

    public CartPage getCartPage() {
        return (cartPage==null) ? cartPage = new  CartPage(driver) : cartPage;}
}