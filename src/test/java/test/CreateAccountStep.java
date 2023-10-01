package test;





import org.junit.jupiter.api.*;



public class CreateAccountStep extends BaseStep {




    @DisplayName("Home page url test")
    public void homePageUrlTest() {

        homePage.goToHomePage();
        Assertions.assertEquals(driver.getCurrentUrl(), homePage.getBaseUrl(), "HomePage upload");
    }

    @DisplayName("User logged or not logged test")
    public void loginStatusTest() {
       Assumptions.assumeTrue(navigationBar.loginButtonDisplayed(), "Logit/Signup link not displaed");
    }
    @DisplayName("Login/Signup link in Navigation Bar test")
    public void loginLinkNavBarTest() {

       Assumptions.assumeTrue(navigationBar.loginButtonDisplayed(), "Login/Signup link not displayed");
        navigationBar.clickLogin();

    }
    @DisplayName("Login page upload test")
    public void loginPageUploadTest() {
       Assertions.assertEquals(loginPage.getBaseUrl(), driver.getCurrentUrl());

    }

    public void signupFormTest() {
       Assumptions.assumeTrue(loginPage.signupFormDisplayed(), "Signup form is displayed");

    }

    @DisplayName("Name field Signup form test")
    public void signupNameFieldTest(String nickName) {

       Assumptions.assumeTrue(loginPage.nameSignupInputFieldDisplayed(), "Name field Signup form displayed");
        loginPage.nameInput(nickName);
    }


    public void signupEmailFieldTest(String email) {
       loginPage.emailInputSignupForm(email);
    }

    public void signupButtonTest() {
       loginPage.signupButtonClick();
        Assertions.assertEquals(signupPage.getBaseUrl(),driver.getCurrentUrl());
    }

    public void accountInformationFormTest() {

        Assertions.assertEquals(signupPage.getBaseUrl(),driver.getCurrentUrl());
        Assumptions.assumeTrue(signupPage.accountInformatinFormIsPresent(), "Account Information form is not displayed");
    }

    public void titleRadioButtonTest() {
        signupPage.titleSelect();
    }

    public void nameAccountInformationFieldTest() {
    }

    public void emailAccountInformationFieldTest() {

    }

    public void passwdAccountInformationFieldTest(String password) {
       signupPage.passwdInput(password);
    }

    public void dayOfBirthTest() {
       signupPage.daySelect();
    }

    public void monthOfBirthTest() {
       signupPage.monthSelect();
    }

    public void yearOfBirthTest() {
       signupPage.yearSelect();
    }

    public void checkConfirmSignUpForOurNewsletterTest() {
        signupPage.newsletterClick();
    }

    public void checkConfirmReceiveSpecialOffersFromOurPartnersTest() {
        signupPage.offerClick();
    }

    public void firstNameInputFieldAddressInfoTest(String firstName) {
       signupPage.first_nameInput(firstName);
    }

    public void lastNameInputFieldAddressInfoTest(String lastName) {
       signupPage.last_nameInput(lastName);
    }

    public void addressInputFieldAddressInfoTest(String address) {
       signupPage.addressInput(address);
    }

    public void countrySelectFieldAddressInfoTest(String country) {
       signupPage.countrySelect(country);
    }

    public void stateInputFieldAddressInfoTest(String state) {
       signupPage.stateInput(state);
    }

    public void cityInputFieldAddressInfoTest(String city) {
       signupPage.cityInput(city);
    }

    public void zipcodeInputFieldAddressInfoTest(Integer zipcode) {
       signupPage.zipcodeInput(zipcode);
    }

    public void phoneInputFieldAddressInfoTest(String phone) {
       signupPage.phoneInput(phone);
    }

    public void createAccountButtonTest() {
       signupPage.createAccButtonClick();
    }

    public void createAccountMessageTest() {

        Assertions.assertEquals(createAccountMessage.accCreateMessageTextGet(), "ACCOUNT CREATED!");
    }

    public void confirmButtonAccountCreatedMessageTest() {

        createAccountMessage.accCreateConfirm();
    }

    public void returnToHomePageTest() {
       Assertions.assertEquals(driver.getCurrentUrl(),homePage.getBaseUrl());


    }

    public void loggedNameInNavBarTest() {
       Assertions.assertEquals(navigationBar.loggedNameGet(), loginPage.getName());
    }








    public void driverStop() {
        driver.quit();
    }
}
