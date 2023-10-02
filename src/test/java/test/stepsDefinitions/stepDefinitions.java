package test.stepsDefinitions;


import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.*;


public class stepDefinitions{

    CreateAccountSteps createAccountSteps = new CreateAccountSteps();
    DeleteAccountSteps deleteAccountSteps = new DeleteAccountSteps();
    LogoutSteps logoutSteps = new LogoutSteps();
    LoginSteps loginSteps = new LoginSteps();

    @AfterAll
    public static void closeDriver(){
        BaseStep.getDriver().quit();
    }

    //START FEATURE

    // START REGISTRATION

    @Given("John on HomePage")
    public void johnOnHomePage() {
        createAccountSteps.homePageUrlTest();
    }

    @Given("John not logged")
    public void johnNotLogged() {
        createAccountSteps.loginStatusTest();
    }

    @When("John press Signup\\/Login")
    public void johnPressSignupLogin() {

        createAccountSteps.loginLinkNavBarTest();
        createAccountSteps.loginPageUploadTest();

    }

    @When("John put {string} and  {string} in Signup form")
    public void johnPutAndInSignupForm(String nickName, String email) {
        createAccountSteps.signupNameFieldTest(nickName);
        createAccountSteps.signupEmailFieldTest(email);
        createAccountSteps.signupButtonTest();

    }

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

    @Then("John back to HomePage")
    public void johnBackToHomePage() {
        createAccountSteps.returnToHomePageTest();
    }

    @Then("John is logged")
    public void johnIsLogged() {
        createAccountSteps.loggedNameInNavBarTest();
    }

    // END OF REGISTRATION

    //START LOGOUT
    @When("John press Logout")
    public void johnPressLogout() {
        logoutSteps.logoutLinkInNavBarTest();
    }

    @When("John move to LoginPage")
    public void johnMoveToLoginPage() {
        createAccountSteps.loginPageUploadTest();
    }
    //END LOGOUT

    //START LOGIN

    @When("John put {string} and {string} in Login form")
    public void johnPutAndInLoginForm(String email, String password) {
        loginSteps.emailInputLoginFormTest(email);
        loginSteps.passwdInputLoginFormTest(password);
        loginSteps.loginButtonTest();
    }
    //END LOGIN

    //START DELETE
    @When("Press DeleteAccount")
    public void pressDeleteAccount() {
        deleteAccountSteps.deleteAccountNavBarLinkTest();
    }

    @When("Confirm Account Deleted message")
    public void confirmAccountDeletedMessage() {
        deleteAccountSteps.deleteAccountMessageTest();
    }
    //END DELETE

//    END OF FEATURE

}

