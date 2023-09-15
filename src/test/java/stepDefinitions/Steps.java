package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.managers.PageObjectManager;
import org.example.pages.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


public class Steps {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    AccountCreated accountCreated;
    AccountDelete accountDelete;
    PageObjectManager pageObjectManager;

    TestBase testBase = new TestBase();
    @Before
    public void setTestArea() {

        driver = TestBase.initialize();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        loginPage = pageObjectManager.getLoginPage();
        signUpPage=pageObjectManager.getSignUpPage();
        accountCreated = pageObjectManager.getAccountCreated();
        accountDelete = pageObjectManager.getAccountDelete();

    }
    @After
    public void cleanArea(){
        driver.quit();
    }


    @Given("I am on HomePage")
    public void i_am_on_home_page() {
        homePage.goToHomePage();

    }

    @Given("I am not logged")
    public void i_am_not_logged() {
        Assertions.assertEquals("Signup / Login", homePage.notLogged());

    }

    @When("I click to Login {string} Singin button")
    public void i_click_to_login_singin_button(String string) {
        homePage.clickLogin();
    }

    @Then("I create New user")
    public void i_create_new_user() {
        loginPage.createUser("Robert", "Bob808@gmail.com");
    }

    @When("I click to Singup button")
    public void i_click_to_singup_button() {
        loginPage.clickSignUp();
    }

    @Then("I fill to registration form")
    public void i_fill_to_registration_form() {
        signUpPage.addAccountInformation("1234", 8, 9, 2023);
        signUpPage.addAddressInformation("Robert", "Kowalski", "ASD", "RedStreet12", "GreenStreet13","Alberta", "Ednomton", 17123, 172321155);
    }

    @When("I click to Create Account button")
    public void i_click_to_create_account_button() {
        signUpPage.clickCreateAccount();
    }

    @Then("New User Account was created")
    public void new_user_account_was_created() {
        System.out.println(accountCreated.confirmAccountCreated());
       Assertions.assertEquals("ACCOUNT CREATED!", accountCreated.confirmAccountCreated());
    }

    @When("I click to Continue button")
    public void i_click_to_continue_button() {
        accountCreated.clickButtonContinue();
        String url = driver.getCurrentUrl();
        if (url.equals("https://automationexercise.com/account_created#google_vignette")) {
            driver.get("https://automationexercise.com/account_created");
            accountCreated.clickButtonContinue();

        }
    }
    @Then("I am on HomePage logged like New User")
    public void i_am_on_home_page_logged_like_new_user () {
        Assertions.assertEquals(driver.getCurrentUrl(), homePage.getBaseUrl());
        Assertions.assertEquals(homePage.loggedNameGet(),"Robert");

    }

    @When("User Click Delete Account button")
    public void userClickDeleteAccountButton() {
        homePage.deleteAccount();
    }
    @Then("User Account was Deleted")
    public void userAccountWasDeleted() {
        accountDelete.accDeleteConfirm();
    }

}