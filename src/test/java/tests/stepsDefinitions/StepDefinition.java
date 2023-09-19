package tests.stepsDefinitions;


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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class StepDefinition {


    static WebDriver driver;


    HomePage homePage;
    HeaderComponent headerComponent;
    LoginPage loginPage;
    SignupPage signupPage;
    CreateAccountMassage createAccountMassage;
    DeleteAccountMasage deleteAccountMasage;
    PageObjectManager pageObjectManager = new PageObjectManager(driver);


    @BeforeAll
    public static void startBrowser() {
        driver = WebDriverSetup.initializeDriver();
    }

    @AfterAll
    public static void quitBrowser() {
       driver.quit();
    }
    @Before
    public void setupEnvironment(){
        homePage = pageObjectManager.getHomePage();
        headerComponent = pageObjectManager.getHeaderComponent();
        loginPage = pageObjectManager.getLoginPage();
        signupPage = pageObjectManager.getSignupPage();
        createAccountMassage = pageObjectManager.getAccountCreatedPage();
        deleteAccountMasage = pageObjectManager.getDeleteAccountPage();

    }

    @Given("John is not registered user")
    public void johnIsNotRegisteredUser() {
    }


    @Given("John on HomePage")
    public void johnOnHomePage() {
//        homePage = pageObjectManager.getHomePage();
        homePage.goToHomePage();
        Assertions.assertEquals(homePage.urlCurrentGet(), homePage.getBaseUrl());

    }

    @When("John press Signup\\/Login")
    public void johnPressSignupLogin() {

        headerComponent.clickLogin();
    }
    @When("John move to LoginPage")
    public void johnMoveToLoginPage() {

        Assertions.assertEquals("https://automationexercise.com/login",driver.getCurrentUrl());

    }
    @Then("John be able to fill signup form")
    public void johnBeAbleToFillSignupForm() {
        Assertions.assertEquals(loginPage.getBaseUrl(),driver.getCurrentUrl());
    }
    @When("John input Name: {string}")
    public void johnInputName(String name) {
//        loginPage = pageObjectManager.getLoginPage();
        loginPage.nameInput(name);
    }
    @When("John input Email Address: {string}")
    public void johnInputEmailAddress(String email) {
        loginPage.emailInputSignupForm(email);
    }
    @Then("John can signup")
    public void johnCanSingup() {
        loginPage.signupButtonClick();
    }
    @When("John on SignupPage")
    public void johnOnSignupPage() {
//        Assertions.assertEquals(signupPage.getBaseUrl(),driver.getCurrentUrl());
        signupPage.accountInformatinFormIsPresent();
    }

    @When("John select gender")
    public void johnSelectGender() {
        signupPage.titleSelect();
    }
    @When("John create password:{string}")
    public void johnCreatePassword(String password) {
        signupPage.passwdInput(password);
    }
    @When("John input his Date of Birth: <{int} June {int}>")
    public void johnInputHisDateOfBirthJune(Integer int1, Integer int2)  {
        signupPage.daySelect();
        signupPage.monthSelect();
        signupPage.yearSelect();
    }
    @When("confirm: Sign up for our newsletter!")
    public void confirmSignUpForOurNewsletter() {
        signupPage.newsletterClick();
    }
    @When("confirm: Receive special offers from our partners!")
    public void confirmReceiveSpecialOffersFromOurPartners() {
        signupPage.offerClick();
    }

    @When("John input First name: {string}")
    public void johnInputFirstName(String firstName) {

        signupPage.first_nameInput(firstName);

    }
    @When("John input Last name: {string}")
    public void johnInputLastName(String lastName) {
        signupPage.last_nameInput(lastName);

    }
    @When("John input Address: {string}")
    public void johnInputAddress(String address) {
        signupPage.addressInput(address);
    }
    @When("John input Country: {string}")
    public void johnInputCountry(String string) {
        signupPage.countrySelect();
    }
    @When("John input State: {string}")
    public void johnInputState(String state) {
        signupPage.stateInput(state);
    }
    @When("John input City: {string}")
    public void johnInputCity(String city) {
        signupPage.cityInput(city);
    }
    @When("John input Zipcode: {int}")
    public void johnInputZipcode(Integer zipcode) {
        signupPage.zipcodeInput(zipcode);
    }
    @When("John input Mobile Number: {string}")
    public void johnInputMobileNumber(String phone) {
        signupPage.phoneInput(phone);
    }
    @Then("John can Create Account")
    public void johnCanCreateAccount() {
        signupPage.createAccButtonClick();
    }
    @When("John see Account Created massage")
    public void johnOnAccountCreatedMassagePage() {
        Assertions.assertEquals(createAccountMassage.accCreateMassageTextget(),"ACCOUNT CREATED!");
    }
    @When("John press Continue")
    public void johnPressContinue() {
        createAccountMassage.accCreateConfirm();

    }
    @Then("John back to HomePage")
    public void johnBackToHomePage() {
        Assertions.assertEquals(driver.getCurrentUrl(),homePage.getBaseUrl());
    }
    @Then("John is logged")
    public void johnIsLogged() {
        Assertions.assertEquals(headerComponent.loggedNameGet(),loginPage.getName());
    }
    @When("John press Logout")
    public void johnPressLogout() {
        headerComponent.clickLogout();
    }
    @Then("John not logged")
    public void johnNotLogged() {
    Assumptions.assumeTrue(headerComponent.loginButtonDisplaed());
    }
    @When("John input e-mail {string}")
    public void johnInputEMail(String email) {
     loginPage.emailLoginInputField(email);
    }
    @When("John input password {string}")
    public void johnInputPassword(String passwd) {
            loginPage.PasswdLLoginInputField(passwd);
    }
    @When("John press Login")
    public void johnPressLogin() {
        loginPage.loginButtonSubmit();

    }

    @When("Press DeleteAccount")
    public void pressDeleteAccount() {
        headerComponent.deleteAccount();
    }
    @When("Confirm Account Deleted masage")
    public void confirmAccountDeletedMasage() {
Assertions.assertEquals(deleteAccountMasage.accDeleteMassageTextget(),"ACCOUNT DELETED!");
deleteAccountMasage.accDeleteConfirm();

    }

}

