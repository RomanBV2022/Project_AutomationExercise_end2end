package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.managers.PageObjectManager;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;


public class Steps {
    WebDriver driver = null;
    HomePage homePage;
    PageObjectManager pageObjectManager;

    TestBase testBase = new TestBase();

    @Given("I am on HomePage'")
    public void i_am_on_home_page() {

        driver = testBase.initialize();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.goToHomePage();


    }

    @When("Verify that home page is visible successfully")
    public void i_verify_that_home_page_is_visible_successfully() {
        homePage.tearDown();
    }
}