package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.managers.PageObjectManager;
import org.example.pages.AccountCreated;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.SignUpPage;

import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebDriver;


public class Steps extends TestBase {
    WebDriver driver = null;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    AccountCreated accountCreated;

    PageObjectManager pageObjectManager;


    //    Scenario: Registration new account for "Robert"
    @Given("I am on HomePage")
    public void i_am_on_home_page() {
        driver = initialize();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.goToHomePage();
    }

    @And ("I am not logged")
    public void i_am_not_logged() {
        Assertions.assertEquals("Signup / Login", homePage.notLogged());
    }

    @When("I click to Login {string} SingIn button to create account")
    public void i_click_to_login_sing_in_button_to_create_account(String string) {
        homePage.clickLogin();
    }

    @And("I create <Robert`s> account")
    public void i_create_robert_s_account() {
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
        loginPage.createUser("Robert", "Bob808@gmail.com");
        loginPage.clickSignUp();
    }


    @And("I fill registration form and submit")
    public void i_fill_registration_form_and_submit() {
        pageObjectManager = new PageObjectManager(driver);
        signUpPage = pageObjectManager.getSignUpPage();
        signUpPage.addAccountInformation("1234", 8, 9, 2023);
        signUpPage.addAddressInformation("Robert", "Kowalski", "ASD", "RedStreet12", "GreenStreet13", "Alberta", "Ednomton", 17123, 172321155);
        signUpPage.clickCreateAccount();
    }

    @And("I verify that account created")
    public void i_verify_that_account_created() {
        pageObjectManager = new PageObjectManager(driver);
        accountCreated = pageObjectManager.getAccountCreated();
        System.out.println(accountCreated.confirmAccountCreated());
        Assertions.assertEquals("ACCOUNT CREATED!", accountCreated.confirmAccountCreated());
    }


    @Then("I am on HomePage logged in <Robert> account")
    public void i_am_on_home_page_logged_in_robert_account() {
        accountCreated.clickButtonContinue();
        accountCreated.clickDismissAdd();
        Assertions.assertEquals("Home", accountCreated.showHomePage());
        Assertions.assertEquals("Robert", accountCreated.showLoggedUser());
        driver.quit();
    }

    //Scenario: Logout  from "Robert" account
    @Given(": I am on HomePage and I am not logged")
    public void i_am_on_home_page_and_i_am_not_logged() {
        driver = initialize();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.goToHomePage();
        homePage.getHomeLink();
        System.out.println(homePage.getHomeLink());
        Assertions.assertEquals("color: orange;", homePage.getHomeLink());
    }

    @When(":  I click login  for moving to Login page and login to <Robert`s> account")
    public void i_click_login_for_moving_to_login_page_and_login_to_robert_s_account() {
        homePage.clickLogin();
        pageObjectManager = new PageObjectManager(driver);
        loginPage =pageObjectManager.getLoginPage();
        loginPage.logIn("Bob808@gmail.com", "1234");
    }

    @And(":   I click  Logout link for logout from <Robert`s> account")
    public void i_click_logout_link_for_logout_from_robert_s_account() {
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        System.out.println(homePage.checkNameUser());
        Assertions.assertEquals("Robert", homePage.checkNameUser());
        homePage.clickLogOut();

    }

    @Then(":  I logout from <Robert`s> account")
    public void i_logout_from_robert_account() {
        pageObjectManager = new PageObjectManager(driver);
        loginPage =pageObjectManager.getLoginPage();
        Assertions.assertEquals("Signup / Login", loginPage.notLogged());
        driver.quit();
    }


    //Scenario: Login to <Robert> account with correct email and Delete account
    @Given("I am on HomePage and not logged")
    public void i_am_on_home_page_and_not_logged() {

    }

    @When("I click login link for moving to Login page and login to <Robert`s> account")
    public void i_click_login_link_for_moving_to_login_page_and_login_to_robert_s_account() {

    }

    @When("I click Delete button to delete account")
    public void i_click_delete_button_to_delete_account() {

    }

    @Then("<Robert> Account was Deleted")
    public void robert_account_was_deleted() {

    }


}