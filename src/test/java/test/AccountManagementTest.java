package test;

import org.example.managers.PageObjectManager;
import org.example.managers.WebDriverSetup;
import org.example.pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountManagementTest {
    //    WebDriver driver;
    static WebDriver driver = WebDriverSetup.initializeDriver();
    HomePage homePage;
    NavigationBar navigationBar;
    LoginPage loginPage;
    SignupPage signupPage;
    CreateAccountMassage createAccountMassage;
    DeleteAccountMasage deleteAccountMasage;
    PageObjectManager pageObjectManager = new PageObjectManager(driver);


//    @BeforeAll
//    public static void setupEnvironment() {
//        WebDriver driver = WebDriverSetup.initializeDriver();
//
//    }


//    @AfterAll
//    public static void closeDriver() {
//        driver.quit();
//
//    }
//    @BeforeEach
//    public void setPageObjects() {
//        homePage = pageObjectManager.getHomePage();
//        navigationBar = pageObjectManager.getNavigationBar();
//        loginPage = pageObjectManager.getLoginPage();
//        signupPage = pageObjectManager.getSignupPage();
//        createAccountMassage = pageObjectManager.getAccountCreatedPage();
//        deleteAccountMasage = pageObjectManager.getDeleteAccountPage();
//
//
//    }



    @Test
    @Order(10)
    @DisplayName("Home page url test")
    public void homePageUrlTest() {
//        this.homePage=homePage;
        homePage = pageObjectManager.getHomePage();
        homePage.goToHomePage();
        Assertions.assertEquals(homePage.urlCurrentGet(), homePage.getBaseUrl(), "HomePage upload");
    }

    @Test
    @Order(15)
    @DisplayName("User logged or not logged test")
    public void loginStatusTest() {
//        this.navigationBar = navigationBar;
        navigationBar = pageObjectManager.getNavigationBar();
        Assumptions.assumeTrue(navigationBar.loginButtonDisplaed(), "Logit/Signup link is displaed");
    }

    @Test
    @Order(20)
    @DisplayName("Login/Signup link in Navigation Bar test")
    public void loginLinkNavBarTest() {

        navigationBar = pageObjectManager.getNavigationBar();
        loginPage = pageObjectManager.getLoginPage();
        loginPage = pageObjectManager.getLoginPage();
        Assumptions.assumeTrue(navigationBar.loginButtonDisplaed(), "Logit/Signup link is displaed");
        navigationBar.clickLogin();

    }
    @Test
    @Order(25)
    public void loginPageUploadTest(){
        loginPage=pageObjectManager.getLoginPage();
        Assertions.assertEquals(loginPage.getBaseUrl(), driver.getCurrentUrl());

    }
    @Test
    @Order(30)
    public void signupFormTest(String name) {
        loginPage=pageObjectManager.getLoginPage();
        Assumptions.assumeTrue(loginPage.signupFormDisplayed(),"Signup form is displayed");

    }

    @Test
    @Order(35)
    @DisplayName("Name field Signup form test")
    public void signupNameFieldTest(String name) {
        loginPage = pageObjectManager.getLoginPage();
        Assumptions.assumeTrue(loginPage.nameSignupInputFieldDisplayed(),"Name field Signup form displayed");
        loginPage.nameInput(name);
    }

    @Test
    @Order(40)
    public void signupEmailFieldTest(String email) {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.emailInputSignupForm(email);
    }

    @Test
    @Order(50)
    public void signupButtonTest() {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.signupButtonClick();
//        Wait<WebDriver> wait;
//        wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(5));
//        signupPage= pageObjectManager.getSignupPage();
//        Assertions.assertEquals(signupPage.getBaseUrl(),driver.getCurrentUrl());
    }

    @Test
    @Order(60)
    public void accountInformationFormTest() {

        signupPage = pageObjectManager.getSignupPage();
//        Assertions.assertEquals(signupPage.getBaseUrl(),driver.getCurrentUrl());
        Assumptions.assumeTrue(signupPage.accountInformatinFormIsPresent(),"Account Information form is not displayed");
    }

    @Test
    @Order(70)
    public void titleRadioButtonTest() {
        signupPage.titleSelect();
    }

    @Test
    @Order(80)
    public void nameAccountInformationFieldTest() {

    }

    @Test
    @Order(90)
    public void emailAccountInformationFieldTest() {

    }

    @Test
    @Order(100)
    public void passwdAccountInformationFieldTest(String password) {
        signupPage = pageObjectManager.getSignupPage();
        signupPage.passwdInput(password);
    }

    @Test
    @Order(110)
    public void dayOfBirthTest() {
        signupPage = pageObjectManager.getSignupPage();
        signupPage.daySelect();
    }

    @Test
    @Order(120)
    public void monthOfBirthTest() {
        signupPage = pageObjectManager.getSignupPage();
        signupPage.monthSelect();
    }

    @Test
    @Order(130)
    public void yearOfBirthTest() {
        signupPage = pageObjectManager.getSignupPage();
        signupPage.yearSelect();
    }

    @Test
    @Order(140)
    public void checkConfirmSignUpForOurNewsletterTest() {
        signupPage.newsletterClick();
    }

    @Test
    @Order(150)
    public void checkConfirmReceiveSpecialOffersFromOurPartnersTest() {
        signupPage.offerClick();
    }
    @Test
    @Order(160)
    public void firstNameInputFieldAddressInfoTest(String firstName){
        signupPage = pageObjectManager.getSignupPage();
        signupPage.first_nameInput(firstName);
    }
    @Test
    @Order(170)
    public void lastNameInputFieldAddressInfoTest(String lastName){
        signupPage = pageObjectManager.getSignupPage();
        signupPage.last_nameInput(lastName);
    }
    @Test
    @Order(180)
    public void addressInputFieldAddressInfoTest(String address){
        signupPage = pageObjectManager.getSignupPage();
        signupPage.addressInput(address);
    }
    @Test
    @Order(190)
    public void countrySelectFieldAddressInfoTest(String country){
        signupPage = pageObjectManager.getSignupPage();
        signupPage.countrySelect(country);
    }
    @Test
    @Order(200)
    public void stateInputFieldAddressInfoTest(String state){
        signupPage = pageObjectManager.getSignupPage();
        signupPage.stateInput(state);
    }
    @Test
    @Order(210)
    public void cityInputFieldAddressInfoTest(String city){
        signupPage = pageObjectManager.getSignupPage();
        signupPage.cityInput(city);
    }
    @Test
    @Order(220)
    public void zipcodeInputFieldAddressInfoTest(Integer zipcode){
        signupPage = pageObjectManager.getSignupPage();
        signupPage.zipcodeInput(zipcode);
    }
    @Test
    @Order(230)
    public void phoneInputFieldAddressInfoTest(String phone){
        signupPage = pageObjectManager.getSignupPage();
        signupPage.phoneInput(phone);
    }
    @Test
    @Order(240)
    public void createAccountButtonTest(){
        signupPage = pageObjectManager.getSignupPage();
        signupPage.createAccButtonClick();
    }
    @Test
    @Order(250)
    public void createAccountMassageTest(){
        createAccountMassage = pageObjectManager.getAccountCreatedMassage();
        Assertions.assertEquals(createAccountMassage.accCreateMassageTextget(), "ACCOUNT CREATED!");
    }
    @Test
    @Order(260)
    public void confirmButtonAccountCreatedMassageTest(){
        createAccountMassage = pageObjectManager.getAccountCreatedMassage();
        createAccountMassage.accCreateConfirm();
    }
    @Test
    @Order(265)
    public void returnToHomePageTest(){
        homePage = pageObjectManager.getHomePage();
        Assertions.assertEquals(driver.getCurrentUrl(), homePage.getBaseUrl());
    }
    @Test
    @Order(270)
    public void loggedNameInNavBarTest(){
        navigationBar = pageObjectManager.getNavigationBar();
        loginPage = pageObjectManager.getLoginPage();
        Assertions.assertEquals(navigationBar.loggedNameGet(), loginPage.getName());
    }
    @Test
    @Order(280)
    public void logoutLinkInNavBarTest(){
        navigationBar = pageObjectManager.getNavigationBar();
        navigationBar.clickLogout();
    }
    @Test
    @Order(290)
    public void emailInputLoginFormTest(String email){
        loginPage = pageObjectManager.getLoginPage();
        loginPage.emailLoginInputField(email);
    }
    @Test
    @Order(300)
    public void passwdInputLoginFormTest(String password){
        loginPage = pageObjectManager.getLoginPage();
        loginPage.PasswdLLoginInputField(password);
    }
    @Test
    @Order(310)
    public void loginButtonTest(){
        loginPage = pageObjectManager.getLoginPage();
        loginPage.loginButtonSubmit();
    }
    @Test
    @Order(320)
    public void deleteAccountNavBarLinkTest(){
        navigationBar = pageObjectManager.getNavigationBar();
        navigationBar.deleteAccount();
    }
    @Test
    @Order(330)
    public void deleteAccountMassageTest(){
        deleteAccountMasage = pageObjectManager.getDeleteAccountMassage();
        Assertions.assertEquals(deleteAccountMasage.accDeleteMassageTextget(), "ACCOUNT DELETED!");
        deleteAccountMasage.accDeleteConfirm();

    }
    @Test
    @Order(340)
    public void driverStop(){
        driver.quit();
    }
}
