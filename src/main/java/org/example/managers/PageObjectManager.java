package org.example.managers;

import org.example.pages.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private NavigationBar navigationBar;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private CreateAccountMessage createAccountMessage;
    private DeleteAccountMessage deleteAccountMessage;

    public PageObjectManager() {
    }

    public PageObjectManager(HomePage homePage) {

        this.homePage = homePage;
    }

    public PageObjectManager(NavigationBar navigationBar) {

        this.navigationBar = navigationBar;
    }

    public PageObjectManager(LoginPage loginPage) {

        this.loginPage = loginPage;
    }

    public PageObjectManager(SignupPage signupPage) {

        this.signupPage = signupPage;
    }
    public PageObjectManager(DeleteAccountMessage deleteAccountMessage) {

        this.deleteAccountMessage = deleteAccountMessage;
    }

    public PageObjectManager(CreateAccountMessage createAccountMessage) {

        this.createAccountMessage = createAccountMessage;
    }

    public PageObjectManager(WebDriver driver) {
        this.driver =driver;
    }


    public HomePage getHomePage() {

        return (homePage == null) ?
                homePage = new HomePage(driver) : homePage;
    }

    public NavigationBar getNavigationBar() {
        return (navigationBar == null) ?
                navigationBar = new NavigationBar(driver) : navigationBar;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public SignupPage getSignupPage() {
        return (signupPage == null) ? signupPage = new SignupPage(driver) : signupPage;
    }

    public CreateAccountMessage getCreateAccountMessage() {
        return (createAccountMessage == null) ? createAccountMessage = new CreateAccountMessage(driver) : createAccountMessage;
    }

    public DeleteAccountMessage getDeleteAccountMessage() {
        return (deleteAccountMessage == null) ? deleteAccountMessage = new DeleteAccountMessage(driver) : deleteAccountMessage;
    }

}
