package test;

import org.example.managers.PageObjectManager;
import org.example.managers.WebDriverSetup;
import org.example.pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LogoutTest {
     WebDriver driver;
    static HomePage homePage;
    NavigationBar navigationBar;
    LoginPage loginPage;
    PageObjectManager pageObjectManager = new PageObjectManager(driver);

    @Test
    @Order(10)
    @DisplayName("Home page url test")
    public void homePageUrlTest() {

        homePage = pageObjectManager.getHomePage();
        homePage.goToHomePage();
        Assertions.assertEquals(driver.getCurrentUrl(), homePage.getBaseUrl(), "HomePage upload");
    }
    @Test
    @Order(20)
    public void loggedNameInNavBarTest(){
        navigationBar = pageObjectManager.getNavigationBar();
        loginPage = pageObjectManager.getLoginPage();
        Assertions.assertEquals(navigationBar.loggedNameGet(), loginPage.getName(),"User not logged");
    }
    @Test
    @Order(30)
    public void logoutLinkInNavBarTest(){
        navigationBar = pageObjectManager.getNavigationBar();
        navigationBar.clickLogout();
    }
    @Test
    @Order(40)
    public void loginPageUploadTest() {
        loginPage = pageObjectManager.getLoginPage();
        Assertions.assertEquals(loginPage.getBaseUrl(), driver.getCurrentUrl());
    }
    @Test
    @Order(50)
    public void loginStatusTest() {
//        this.navigationBar = navigationBar;
        navigationBar = pageObjectManager.getNavigationBar();
        Assumptions.assumeTrue(navigationBar.loginButtonDisplaed(), "Logit/Signup link is displaed");
    }

}
