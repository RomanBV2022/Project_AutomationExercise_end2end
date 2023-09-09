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


public class Steps {
    WebDriver driver = null;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    AccountCreated accountCreated;

    PageObjectManager pageObjectManager;

    TestBase testBase = new TestBase();


    @Given("I am on HomePage")
    public void i_am_on_home_page() {
        driver = testBase.initialize();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
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
        pageObjectManager = new PageObjectManager(driver);
        loginPage = pageObjectManager.getLoginPage();
        loginPage.createUser("Robert", "Bob808@gmail.com");
    }

    @When("I click to Singup button")
    public void i_click_to_singup_button() {
        loginPage.clickSignUp();
    }

    @Then("I fill to registration form")
    public void i_fill_to_registration_form() {
        pageObjectManager =new PageObjectManager(driver);
        signUpPage=pageObjectManager.getSignUpPage();
        signUpPage.addAccountInformation("1234", 8, 9, 2023);
        signUpPage.addAddressInformation("Robert", "Kowalski", "ASD", "RedStreet12", "GreenStreet13","Alberta", "Ednomton", 17123, 172321155);
    }

    @When("I click to Create Account button")
    public void i_click_to_create_account_button() {
        signUpPage.clickCreateAccount();
    }

    @Then("New User Account was created")
    public void new_user_account_was_created() {
        pageObjectManager = new PageObjectManager(driver);
       accountCreated = pageObjectManager.getAccountCreated();
        System.out.println(accountCreated.confirmAccountCreated());
       Assertions.assertEquals("ACCOUNT CREATED!", accountCreated.confirmAccountCreated());
    }

    @When("I click to Continue button")
    public void i_click_to_continue_button() {
        accountCreated.clickButtonContinue();
        accountCreated.clickDismissAdd();
        driver.quit();

    }

    @Then("I am on HomePage logged like New User")
    public void i_am_on_home_page_logged_like_new_user() {
//        System.out.println(accountCreated.showHomePage());
//        System.out.println(accountCreated.showLoggedUser());
//        Assertions.assertEquals(" Home", accountCreated.showHomePage());
//        Assertions.assertEquals("Robert", accountCreated.showLoggedUser());

    }


}