package stepDefinitions;


import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
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


public class Steps  {
    static WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    AccountCreated accountCreated;

    PageObjectManager pageObjectManager = new PageObjectManager(driver);

    @BeforeAll
    public static void setupEnvironment() {
        driver = WebDriverSetup.turnOnDriver();
        System.out.println(driver);
    }

    @AfterAll
    public static void cleanEnvironment() {
        driver.quit();
    }

    @Before
    public void uploadPageObjects() {
        homePage = pageObjectManager.getHomePage();
        loginPage = pageObjectManager.getLoginPage();
        accountCreated = pageObjectManager.getAccountCreated();
        signUpPage = pageObjectManager.getSignUpPage();
        driver.getCurrentUrl();
    }


    //    Scenario: Registration new account for "Robert"
    //***********************************************************************************************************
    @Given("I am on HomePage")
    public void i_am_on_home_page() {
        homePage.goToHomePage();
        driver.getCurrentUrl();
    }

    @And("I am not logged")
    public void i_am_not_logged() throws InterruptedException {
        try {
            //Assertions.assertEquals("Signup / Login", homePage.notLogged());
            System.out.println(driver.getCurrentUrl());
        }
        catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

    }

    @When("I click to Login {string} SingIn button to create account")
    public void i_click_to_login_sing_in_button_to_create_account(String string) {
        homePage.clickLogin();
        System.out.println(driver.getCurrentUrl());


    }

    @And("I create <Robert`s> account")
    public void i_create_robert_s_account() {
        loginPage.createUser("Robert", "Bob808@gmail.com");
        loginPage.clickSignUp();
        System.out.println(driver.getCurrentUrl());

    }


    @And("I fill registration form and submit")
    public void i_fill_registration_form_and_submit() {
        signUpPage.addAccountInformation("1234", 8, 9, 2023);
        signUpPage.addAddressInformation("Robert", "Kowalski", "ASD", "RedStreet12", "GreenStreet13", "Alberta", "Ednomton", 17123, 172321155);
        signUpPage.clickCreateAccount();

    }

    @And("I verify that account created")
    public void i_verify_that_account_created() {
        System.out.println(accountCreated.confirmAccountCreated());
        Assertions.assertEquals("ACCOUNT CREATED!", accountCreated.confirmAccountCreated());
    }


    @Then("I am on HomePage logged in <Robert> account")
    public void i_am_on_home_page_logged_in_robert_account() {
        accountCreated.clickButtonContinue();
        accountCreated.clickDismissAdd();
        Assertions.assertEquals("Home", accountCreated.showHomePage());
        Assertions.assertEquals("Robert", accountCreated.showLoggedUser());
    }

    //Scenario: Logout  from "Robert" account
    //***********************************************************************************************************
    @And("I am login to <Robert`s> account")
    public void i_am_login_to_robert_s_account() {
        loginPage.logIn("Bob808@gmail.com", "1234");

    }

    @And("I verify  accounts holder name")
    public void i_verify_accounts_holder_name() {
        //Assertions.assertEquals("color: orange;", homePage.getHomeLink());
    }

    @And("I click  Logout link for logout from <Robert`s> account")
    public void i_click_logout_link_for_logout_from_robert_s_account() {
        Assertions.assertEquals("Logged in as Robert", homePage.checkNameUser());
        homePage.clickLogOut();

    }

    @Then("I logout from <Robert`s> account")
    public void i_logout_from_robert_account() {
        //Assertions.assertEquals("Signup / Login", homePage.notLogged());
        System.out.println(driver.getCurrentUrl());
    }

    //Scenario: Register <Robert> with existing email
    //***********************************************************************************************************
    @Then("I verify that email exist")
    public void i_verify_that_email_exist() {
        Assertions.assertEquals("Email Address already exist!", signUpPage.showErrorMessageEmailExists());
        System.out.println(signUpPage.showErrorMessageEmailExists());
    }

    //Scenario: Login to <Robert> account with correct email and Delete account
    //***********************************************************************************************************

    @And("I click Delete button to delete account")
    public void i_click_delete_button_to_delete_account() {
        homePage.clickDeleteAccount();
        System.out.println(driver.getCurrentUrl());
    }

    @Then("<Robert> Account was Deleted")
    public void robert_account_was_deleted() {
        System.out.println(driver.getCurrentUrl());
    }


}