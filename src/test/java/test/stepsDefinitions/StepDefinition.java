package test.stepsDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.AccountManagementTest;


public class StepDefinition {


    AccountManagementTest accountManagementTest = new AccountManagementTest();


    //START FEATURE

    // START REGISTRATION

    @Given("John on HomePage")
    public void johnOnHomePage() {
        accountManagementTest.homePageUrlTest();
    }

    @When("John press Signup\\/Login")
    public void johnPressSignupLogin() {
        accountManagementTest.loginLinkNavBarTest();
    }

    @When("John move to LoginPage")
    public void johnMoveToLoginPage() {
        accountManagementTest.loginPageUploadTest();
    }

    @Then("John be able to fill signup form")
    public void johnBeAbleToFillSignupForm() {
    }

    @When("John input Name: {string}")
    public void johnInputName(String name) {
        accountManagementTest.signupNameFieldTest(name);
    }

    @When("John input Email Address: {string}")
    public void johnInputEmailAddress(String email) {
        accountManagementTest.signupEmailFieldTest(email);
    }

    @Then("John can signup")
    public void johnCanSignup() {
        accountManagementTest.signupButtonTest();
    }

    @When("John on SignupPage")
    public void johnOnSignupPage() {
        accountManagementTest.accountInformationFormTest();
    }

    @When("John select gender")
    public void johnSelectGender() {
        accountManagementTest.titleRadioButtonTest();
    }

    @When("John create password:{string}")
    public void johnCreatePassword(String password) {
        accountManagementTest.passwdAccountInformationFieldTest(password);
    }

    @When("John input his Date of Birth: <{int} June {int}>")
    public void johnInputHisDateOfBirthJune(Integer int1, Integer int2) {
        accountManagementTest.dayOfBirthTest();
        accountManagementTest.monthOfBirthTest();
        accountManagementTest.yearOfBirthTest();
    }

    @When("confirm: Sign up for our newsletter!")
    public void confirmSignUpForOurNewsletter() {
        accountManagementTest.checkConfirmSignUpForOurNewsletterTest();
    }

    @When("confirm: Receive special offers from our partners!")
    public void confirmReceiveSpecialOffersFromOurPartners() {
        accountManagementTest.checkConfirmReceiveSpecialOffersFromOurPartnersTest();
    }

    @When("John input First name: {string}")
    public void johnInputFirstName(String firstName) {
        accountManagementTest.firstNameInputFieldAddressInfoTest(firstName);
    }

    @When("John input Last name: {string}")
    public void johnInputLastName(String lastName) {
        accountManagementTest.lastNameInputFieldAddressInfoTest(lastName);
    }

    @When("John input Address: {string}")
    public void johnInputAddress(String address) {
        accountManagementTest.addressInputFieldAddressInfoTest(address);
    }

    @When("John input Country: {string}")
    public void johnInputCountry(String string) {
        accountManagementTest.countrySelectFieldAddressInfoTest();
    }

    @When("John input State: {string}")
    public void johnInputState(String state) {
        accountManagementTest.stateInputFieldAddressInfoTest(state);
    }

    @When("John input City: {string}")
    public void johnInputCity(String city) {
        accountManagementTest.cityInputFieldAddressInfoTest(city);
    }

    @When("John input Zipcode: {int}")
    public void johnInputZipcode(Integer zipcode) {
        accountManagementTest.zipcodeInputFieldAddressInfoTest(zipcode);
    }

    @When("John input Mobile Number: {string}")
    public void johnInputMobileNumber(String phone) {
        accountManagementTest.phoneInputFieldAddressInfoTest(phone);
    }

    @Then("John can Create Account")
    public void johnCanCreateAccount() {
        accountManagementTest.createAccountButtonTest();
    }

    @When("John see Account Created massage")
    public void johnOnAccountCreatedMassagePage() {
        accountManagementTest.createAccountMassageTest();
    }

    @When("John press Continue")
    public void johnPressContinue() {
        accountManagementTest.confirmButtonAccountCreatedMassageTest();
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

    @Then("John not logged")
    public void johnNotLogged() {
        accountManagementTest.loginStatusTest();
    }
    //END LOGOUT

    //START LOGIN
    @When("John input e-mail {string}")
    public void johnInputEMail(String email) {
        accountManagementTest.emailInputLoginFormTest(email);
    }

    @When("John input password {string}")
    public void johnInputPassword(String password) {
        accountManagementTest.passwdInputLoginFormTest(password);

    }

    @When("John press Login")
    public void johnPressLogin() {
        accountManagementTest.loginButtonTest();

    }
    //END LOGIN

    //START DELETE
    @When("Press DeleteAccount")
    public void pressDeleteAccount() {
        accountManagementTest.deleteAccountNavBarLinkTest();
    }

    @When("Confirm Account Deleted masage")
    public void confirmAccountDeletedMassage() {
        accountManagementTest.deleteAccountMassageTest();
    }
    //END DELETE

//    END OF FEATURE

}

