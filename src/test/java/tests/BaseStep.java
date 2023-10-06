package tests;

import org.example.managers.WebDriverSetup;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;

public class BaseStep {

        public static WebDriver driver = WebDriverSetup.initializeDriver();

        HomePage homePage = new HomePage(driver);
        NavigationBar navigationBar = new NavigationBar(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignupPage signupPage = new SignupPage(driver);
        CreateAccountMessage createAccountMessage = new CreateAccountMessage(driver);
        DeleteAccountMessage deleteAccountMessage = new DeleteAccountMessage(driver);
        public static WebDriver getDriver(){
                return driver;
        }
}
