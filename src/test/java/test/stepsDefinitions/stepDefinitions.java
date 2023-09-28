package test.stepsDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.AccountManagementTest;



public class stepDefinitions {

    AccountManagementTest accountManagementTest = new AccountManagementTest();


    //START FEATURE

    // START REGISTRATION

    @Given("John on HomePage")
    public void johnOnHomePage() {
        accountManagementTest.homePageUrlTest();
    }

    @Given("John not logged")
    public void johnNotLogged() {
        accountManagementTest.loginStatusTest();
    }

    @When("John press Signup\\/Login")
    public void johnPressSignupLogin() {

        accountManagementTest.loginLinkNavBarTest();
        accountManagementTest.loginPageUploadTest();

    }

    @When("John put {string} and  {string} in Signup form")
    public void johnPutAndInSignupForm(String nickName, String email) {
        accountManagementTest.signupNameFieldTest(nickName);
        accountManagementTest.signupEmailFieldTest(email);
        accountManagementTest.signupButtonTest();

    }

    @When("John put required data in ACCOUNT INFORMATION form: {string} ,{string}")
    public void johnPutRequiredDataInACCOUNTINFORMATIONForm(String password, String string2) {
        accountManagementTest.accountInformationFormTest();
        accountManagementTest.titleRadioButtonTest();
        accountManagementTest.passwdAccountInformationFieldTest(password);
        accountManagementTest.dayOfBirthTest();
        accountManagementTest.monthOfBirthTest();
        accountManagementTest.yearOfBirthTest();
        accountManagementTest.checkConfirmSignUpForOurNewsletterTest();
        accountManagementTest.checkConfirmReceiveSpecialOffersFromOurPartnersTest();
    }

    @When("John put required data in ADDRESS INFORMATION form: {string}, {string}, {string},  {string}, {string}, {string}, {int},{string}")
    public void johnPutRequiredDataInADDRESSINFORMATIONForm(String firstName, String lastName, String address, String country, String state, String city, Integer zipcode, String phone) {
        accountManagementTest.firstNameInputFieldAddressInfoTest(firstName);
        accountManagementTest.lastNameInputFieldAddressInfoTest(lastName);
        accountManagementTest.addressInputFieldAddressInfoTest(address);
        accountManagementTest.countrySelectFieldAddressInfoTest(country);
        accountManagementTest.stateInputFieldAddressInfoTest(state);
        accountManagementTest.cityInputFieldAddressInfoTest(city);
        accountManagementTest.zipcodeInputFieldAddressInfoTest(zipcode);
        accountManagementTest.phoneInputFieldAddressInfoTest(phone);
        accountManagementTest.createAccountButtonTest();
        accountManagementTest.createAccountMessageTest();
        accountManagementTest.confirmButtonAccountCreatedMessageTest();
    }

    @Then("John back to HomePage")
    public void johnBackToHomePage() {
        accountManagementTest.returnToHomePageTest();
    }

    @Then("John is logged")
    public void johnIsLogged() {
        accountManagementTest.loggedNameInNavBarTest();
    }

    // END OF REGISTRATION

    //START LOGOUT
    @When("John press Logout")
    public void johnPressLogout() {
        accountManagementTest.logoutLinkInNavBarTest();
    }

    @When("John move to LoginPage")
    public void johnMoveToLoginPage() {
        accountManagementTest.loginPageUploadTest();
    }
    //END LOGOUT

    //START LOGIN

    @When("John put {string} and {string} in Login form")
    public void johnPutAndInLoginForm(String email, String password) {
        accountManagementTest.emailInputLoginFormTest(email);
        accountManagementTest.passwdInputLoginFormTest(password);
        accountManagementTest.loginButtonTest();
    }
    //END LOGIN

    //START DELETE
    @When("Press DeleteAccount")
    public void pressDeleteAccount() {
        accountManagementTest.deleteAccountNavBarLinkTest();
    }

    @When("Confirm Account Deleted message")
    public void confirmAccountDeletedMessage() {
        accountManagementTest.deleteAccountMessageTest();
    }
    //END DELETE

//    END OF FEATURE

}

