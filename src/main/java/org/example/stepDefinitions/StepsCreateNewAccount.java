package org.example.stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.managers.PageObjectManager;
import org.example.managers.WebDriverSetup;
import org.example.pages.*;
import org.junit.jupiter.api.Assumptions;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;


public class StepsCreateNewAccount {

//    WebDriver driver = WebDriverSetup.initializeDriver();
//
//
//    PageObjectManager pageObjectManager = new PageObjectManager(driver);
//    HomePage homePage = pageObjectManager.getHomePage();
//    HeaderComponent headerComponent = pageObjectManager.getHeaderComponent();
//    LoginPage loginPage = pageObjectManager.getLoginPage();
//    SignupPage signupPage = pageObjectManager.getSignupPage();
//    AccountCreateMassage accountCreateMassage = pageObjectManager.getAccountCreatedPage();


    WebDriver driver;
    PageObjectManager pageObjectManager;
    HomePage homePage;
    HeaderComponent headerComponent;
    LoginPage loginPage;
    SignupPage signupPage;
   AccountCreateMassage accountCreateMassage;


    @Before
    public void setTestArea() {

        driver = WebDriverSetup.initializeDriver();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        headerComponent = pageObjectManager.getHeaderComponent();
        loginPage = pageObjectManager.getLoginPage();
        signupPage = pageObjectManager.getSignupPage();
        accountCreateMassage = pageObjectManager.getAccountCreatedPage();
    }

    @Given("User on HomePage")
    public void userOnHomePage() {
        homePage.goToHomePage();
        Assertions.assertEquals(homePage.urlCurrentGet(),homePage.baseUrl);
    }

    @Given("User not logged")
    public void userNotLogged() {
        headerComponent.loginButtonDisplaedWait();

    }

    @When("User move to login page")
    public void userMoveToLoginPage() {
        headerComponent.clickLogin();
    }

    @When("User correct fill form")
    public void userCorrectFillForm() {
        loginPage.nameInput();
        loginPage.emailInput();
    }

    @When("User press Signup")
    public void userPressSignup() {
        loginPage.signupButtonClick();
    }

    @When("User move to Signup page")
    public void userMoveToSignupPage() {

    }

    @When("User correct fill to registration form")
    public void userCorrectFillToRegistrationForm() {
        signupPage.titleSelect();
        signupPage.passwdInput();
        signupPage.daySelect();
        signupPage.monthSelect();
        signupPage.yearSelect();
        signupPage.newsletterClick();
        signupPage.offerClick();
        signupPage.first_nameInput();
        signupPage.last_nameInput();
        signupPage.addressInput();
        signupPage.countrySelect();
        signupPage.stateInput();
        signupPage.cityInput();
        signupPage.zipcodeInput();
        signupPage.phoneInput();
    }

    @When("User press Create Account")
    public void userPressCreateAccount() {
        signupPage.createAccButtonClick();
    }

    @Then("New User Account was created")
    public void newUserAccountWasCreated() {
        Assertions.assertEquals(accountCreateMassage.accCreateMassageTextget(),"ACCOUNT CREATED!");
    }

    @When("User press Continue")
    public void userPressContinue() {
        accountCreateMassage.accCreateConfirm();
        String url = driver.getCurrentUrl();
        if (url.equals("https://automationexercise.com/account_created#google_vignette")) {
            driver.get("https://automationexercise.com/account_created");
            accountCreateMassage.accCreateConfirm();
        }
    }

    @Then("User back to Home Page")
    public void userBackToHomePage() {

        Assertions.assertEquals(homePage.urlCurrentGet(), homePage.baseUrl);
    }
    @Then("User is logged")
    public void userIsLogged() {

//        Assertions.assertEquals(headerComponent.loggedNameGet(),loginPage.inputedNameGet());
    }



//    @AfterAll
//    public void removeDriver() {
//
////        driver.quit();

//    }


}