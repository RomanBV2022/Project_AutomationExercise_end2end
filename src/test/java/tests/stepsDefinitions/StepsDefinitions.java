package tests.stepsDefinitions;


import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import tests.BaseStep;
import tests.LoginSteps;
import tests.LogoutSteps;
import tests.CreateAccountSteps;
import tests.DeleteAccountSteps;

import static tests.BaseStep.getDriver;


public class StepsDefinitions {

    CreateAccountSteps createAccountSteps = new CreateAccountSteps();
    DeleteAccountSteps deleteAccountSteps = new DeleteAccountSteps();
    LogoutSteps logoutSteps = new LogoutSteps();
    LoginSteps loginSteps = new LoginSteps();


    @AfterAll
    public static void closeDriver(){
        getDriver().quit();
    }

    //START FEATURE

    // START REGISTRATION

    @Test
    @Given("John on HomePage")
    public void johnOnHomePage() {
        createAccountSteps.navigateToHomePage();
    }

    @Test
    @Given("John not logged")
    public void johnNotLogged() {
        createAccountSteps.loginStatusTest();
    }

    @Test
    @When("John press Signup\\/Login")
    public void johnPressSignupLogin() {

        createAccountSteps.loginLinkNavBarTest();
        createAccountSteps.loginPageUploadTest();

    }

    @Test
    @When("John put {string} and  {string} in Signup form")
    public void johnPutAndInSignupForm(String nickName, String email) {
        createAccountSteps.signupNameFieldTest(nickName);
        createAccountSteps.signupEmailFieldTest(email);
        createAccountSteps.signupButtonTest();

    }

    @Test
    @When("John put required data in ACCOUNT INFORMATION form: {string} ,DateOfBirth")
    public void johnPutRequiredDataInACCOUNTINFORMATIONForm(String password) {
        createAccountSteps.accountInformationFormTest();
        createAccountSteps.titleRadioButtonTest();
        createAccountSteps.passwdAccountInformationFieldTest(password);
        createAccountSteps.dayOfBirthTest();
        createAccountSteps.monthOfBirthTest();
        createAccountSteps.yearOfBirthTest();
        createAccountSteps.checkConfirmSignUpForOurNewsletterTest();
        createAccountSteps.checkConfirmReceiveSpecialOffersFromOurPartnersTest();
    }

    @Test
    @When("John put required data in ADDRESS INFORMATION form: {string}, {string}, {string},  {string}, {string}, {string}, {int},{string}")
    public void johnPutRequiredDataInADDRESSINFORMATIONForm(String firstName, String lastName, String address, String country, String state, String city, Integer zipcode, String phone) {
        createAccountSteps.firstNameInputFieldAddressInfoTest(firstName);
        createAccountSteps.lastNameInputFieldAddressInfoTest(lastName);
        createAccountSteps.addressInputFieldAddressInfoTest(address);
        createAccountSteps.countrySelectFieldAddressInfoTest(country);
        createAccountSteps.stateInputFieldAddressInfoTest(state);
        createAccountSteps.cityInputFieldAddressInfoTest(city);
        createAccountSteps.zipcodeInputFieldAddressInfoTest(zipcode);
        createAccountSteps.phoneInputFieldAddressInfoTest(phone);
        createAccountSteps.createAccountButtonTest();
        createAccountSteps.createAccountMessageTest();
        createAccountSteps.confirmButtonAccountCreatedMessageTest();
    }

    @Test
    @Then("John back to HomePage")
    public void johnBackToHomePage() {
        createAccountSteps.returnToHomePageTest();
    }

    @Test
    @Then("John is logged")
    public void johnIsLogged() {
        createAccountSteps.loggedNameInNavBarTest();
    }

    // END OF REGISTRATION

    //START LOGOUT

    @Test
    @When("John press Logout")
    public void johnPressLogout() {
        logoutSteps.logoutLinkInNavBarTest();
    }

    @Test
    @When("John move to LoginPage")
    public void johnMoveToLoginPage() {
        createAccountSteps.loginPageUploadTest();
    }
    //END LOGOUT

    //START LOGIN

    @Test
    @When("John put {string} and {string} in Login form")
    public void johnPutAndInLoginForm(String email, String password) {
        loginSteps.emailInputLoginFormTest(email);
        loginSteps.passwdInputLoginFormTest(password);
        loginSteps.loginButtonTest();
    }
    //END LOGIN

    //START DELETE

    @Test
    @When("Press DeleteAccount")
    public void pressDeleteAccount() {
        deleteAccountSteps.deleteAccountNavBarLinkTest();
    }

    @Test
    @When("Confirm Account Deleted message")
    public void confirmAccountDeletedMessage() {
        deleteAccountSteps.deleteAccountMessageTest();
    }
    //END DELETE

//    END OF FEATURE

}

