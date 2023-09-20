package test.stepsDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.managers.PageObjectManager;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;
import test.RegistrationTest;


public class StepDefinition {


    static WebDriver driver;


    HomePage homePage;
    NavigationBar navigationBar;
    LoginPage loginPage;
    SignupPage signupPage;
    CreateAccountMassage createAccountMassage;
    DeleteAccountMasage deleteAccountMasage;
    PageObjectManager pageObjectManager = new PageObjectManager(driver);
    RegistrationTest registrationTest = new RegistrationTest();

//    @BeforeAll
//    public static void setupEnvironment() {
//        driver = WebDriverSetup.initializeDriver();
//    }
//
//    @AfterAll
//    public static void cleanEnvironment() {
//        driver.quit();
//    }
//
//    @Before
//    public void uploadPageObjects() {
//        homePage = pageObjectManager.getHomePage();
//        navigationBar = pageObjectManager.getNavigationBar();
//        loginPage = pageObjectManager.getLoginPage();
//        signupPage = pageObjectManager.getSignupPage();
//        createAccountMassage = pageObjectManager.getAccountCreatedPage();
//        deleteAccountMasage = pageObjectManager.getDeleteAccountPage();
//
//
//    }
    //START FEATURE

    // START REGISTRATION

    @Given("John on HomePage")
    public void johnOnHomePage() {
        registrationTest.homePageUrlTest();
//        homePage.goToHomePage();
//        Assertions.assertEquals(homePage.urlCurrentGet(), homePage.getBaseUrl());

    }

    @When("John press Signup\\/Login")
    public void johnPressSignupLogin() {
        registrationTest.loginLinkNavBarTest();
//        navigationBar.clickLogin();
    }

    @When("John move to LoginPage")
    public void johnMoveToLoginPage() {
        registrationTest.loginPageUploadTest();
    }

    @Then("John be able to fill signup form")
    public void johnBeAbleToFillSignupForm() {

    }

    @When("John input Name: {string}")
    public void johnInputName(String name) {
        registrationTest.signupNameFieldTest(name);
    }

    @When("John input Email Address: {string}")
    public void johnInputEmailAddress(String email) {
        registrationTest.signupEmailFieldTest(email);
    }

    @Then("John can signup")
    public void johnCanSignup() {
        registrationTest.signupButtonTest();
    }

    @When("John on SignupPage")
    public void johnOnSignupPage() {
    registrationTest.accountInformationFormTest();
    }

    @When("John select gender")
    public void johnSelectGender() {
        registrationTest.titleRadioButtonTest();
    }

    @When("John create password:{string}")
    public void johnCreatePassword(String password) {
        registrationTest.passwdAccountInformationFieldTest(password);
    }

    @When("John input his Date of Birth: <{int} June {int}>")
    public void johnInputHisDateOfBirthJune(Integer int1, Integer int2) {
        registrationTest.dayOfBirthTest();
        registrationTest.monthOfBirthTest();
        registrationTest.yearOfBirthTest();
    }

    @When("confirm: Sign up for our newsletter!")
    public void confirmSignUpForOurNewsletter() {
        registrationTest.checkConfirmSignUpForOurNewsletterTest();
    }

    @When("confirm: Receive special offers from our partners!")
    public void confirmReceiveSpecialOffersFromOurPartners() {
        registrationTest.checkConfirmReceiveSpecialOffersFromOurPartnersTest();
    }

    @When("John input First name: {string}")
    public void johnInputFirstName(String firstName) {
registrationTest.firstNameInputFieldAddressInfoTest(firstName);


    }

    @When("John input Last name: {string}")
    public void johnInputLastName(String lastName) {
        registrationTest.lastNameInputFieldAddressInfoTest(lastName);

    }

    @When("John input Address: {string}")
    public void johnInputAddress(String address) {
        registrationTest.addressInputFieldAddressInfoTest(address);
    }

    @When("John input Country: {string}")
    public void johnInputCountry(String string) {
        registrationTest.countrySelectFieldAddressInfoTest();
    }

    @When("John input State: {string}")
    public void johnInputState(String state) {
        registrationTest.stateInputFieldAddressInfoTest(state);
    }

    @When("John input City: {string}")
    public void johnInputCity(String city) {
        registrationTest.cityInputFieldAddressInfoTest(city);
    }

    @When("John input Zipcode: {int}")
    public void johnInputZipcode(Integer zipcode) {
        registrationTest.zipcodeInputFieldAddressInfoTest(zipcode);
    }

    @When("John input Mobile Number: {string}")
    public void johnInputMobileNumber(String phone) {
        registrationTest.phoneInputFieldAddressInfoTest(phone);
    }

    @Then("John can Create Account")
    public void johnCanCreateAccount() {
        registrationTest.createAccountButtonTest();
    }

    @When("John see Account Created massage")
    public void johnOnAccountCreatedMassagePage() {
        registrationTest.createAccountMassageTest();
    }

    @When("John press Continue")
    public void johnPressContinue() {
        registrationTest.confirmButtonAccountCreatedMassageTest();

    }

    @Then("John back to HomePage")
    public void johnBackToHomePage() {
        registrationTest.returnToHomePageTest();
    }

    @Then("John is logged")
    public void johnIsLogged() {
        registrationTest.loggedNameInNavBarTest();
    }

    // END OF REGISTRATION
    //START LOGOUT
    @When("John press Logout")
    public void johnPressLogout() {
        navigationBar.clickLogout();
    }

    @Then("John not logged")
    public void johnNotLogged() {
        registrationTest.loginStatusTest();
    }
    //END LOGOUT

    //START LOGIN
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
    //END LOGIN

    //START DELETE
    @When("Press DeleteAccount")
    public void pressDeleteAccount() {
        navigationBar.deleteAccount();
    }

    @When("Confirm Account Deleted masage")
    public void confirmAccountDeletedMasage() {
        Assertions.assertEquals(deleteAccountMasage.accDeleteMassageTextget(), "ACCOUNT DELETED!");
        deleteAccountMasage.accDeleteConfirm();

    }
    //END DELETE
//    END OF FEATURE
}

