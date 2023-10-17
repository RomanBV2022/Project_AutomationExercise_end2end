package stepDefinitions;


import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.managers.PageObjectManager;
import org.example.pages.*;

import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestSteps {
    static WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    AccountCreated accountCreated;
    ProductsPage productsPage;
    ProductPage productPage;
    CartPage cartPage;
    TestCasesPage testCasesPage;

    PageObjectManager pageObjectManager = new PageObjectManager(driver);

    @BeforeAll
    public static void setupEnvironment() {
        driver = WebDriverSetup.turnOnDriver();

    }

    @AfterAll
    public static void cleanEnvironment() {
        driver.quit();
    }

    @Before
    public void uploadPageObjects() {
        homePage = pageObjectManager.getHomePage();
        loginPage = pageObjectManager.getLoginPage();
        accountCreated = pageObjectManager.getAccountCreated();
        signUpPage = pageObjectManager.getSignUpPage();
        productsPage = pageObjectManager.getProductsPage();
        cartPage = pageObjectManager.getCartPage();
        testCasesPage = pageObjectManager.getTestCasesPage();
        productPage = pageObjectManager.getProductPage();
        testCasesPage = pageObjectManager.getTestCasesPage();

    }


    //    Scenario: Registration new account for "Robert"
    //***********************************************************************************************************
    @Given("I am on HomePage")
    public void i_am_on_home_page() {
        homePage.goToHomePage();
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(url, "https://automationexercise.com/");

    }

    @And("I am not logged")
    public void i_am_not_logged() {
        Assertions.assertEquals("Signup / Login", homePage.getLoginLogoutBtnText());


    }

    @When("I click to Login {string} SingIn button to create account")
    public void i_click_to_login_sing_in_button_to_create_account(String string) {
        homePage.clickLogin();
        System.out.println(driver.getCurrentUrl());


    }

    @And("I create <Robert`s> account")
    public void i_create_robert_s_account() {
        loginPage.createUser("Robert", "Bob808@gmail.com");
        loginPage.clickSignUp();
        System.out.println(driver.getCurrentUrl());

    }


    @And("I fill registration form and submit")
    public void i_fill_registration_form_and_submit() {
        signUpPage.addAccountInformation("1234", 8, 9, 2023);
        signUpPage.addAddressInformation("Robert", "Kowalski", "ASD", "RedStreet12", "GreenStreet13", "Alberta", "Ednomton", 17123, 172321155);
        signUpPage.clickCreateAccount();

    }

    @And("I verify that account created")
    public void i_verify_that_account_created() {
        System.out.println(accountCreated.confirmAccountCreated());
        Assertions.assertEquals("ACCOUNT CREATED!", accountCreated.confirmAccountCreated());
    }


    @Then("I am on HomePage logged in <Robert> account")
    public void i_am_on_home_page_logged_in_robert_account() {
        accountCreated.clickButtonContinue();
        driver.navigate().back();
        driver.navigate().forward();
        Assertions.assertEquals("Home", accountCreated.showHomePage());
        Assertions.assertEquals("Robert", accountCreated.showLoggedUser());
    }

    //Scenario: Logout  from "Robert" account
    //***********************************************************************************************************
    @And("I am login to <Robert`s> account")
    public void i_am_login_to_robert_s_account() {
        loginPage.logIn("Bob808@gmail.com", "1234");

    }

    @And("I verify  accounts holder name")
    public void i_verify_accounts_holder_name() {
        //Assertions.assertEquals("color: orange;", homePage.getHomeLink());
    }

    @And("I click  Logout link for logout from <Robert`s> account")
    public void i_click_logout_link_for_logout_from_robert_s_account() {
        Assertions.assertEquals("Logged in as Robert", homePage.checkNameUser());
        homePage.clickLogOut();

    }

    @Then("I logout from <Robert`s> account")
    public void i_logout_from_robert_account() {
        //Assertions.assertEquals("Signup / Login", homePage.notLogged());
        System.out.println(driver.getCurrentUrl());
    }

    //Scenario: Register <Robert> with existing email
    //***********************************************************************************************************
    @Then("I verify that email exist")
    public void i_verify_that_email_exist() {
        Assertions.assertEquals("Email Address already exist!", signUpPage.showErrorMessageEmailExists());
        System.out.println(signUpPage.showErrorMessageEmailExists());
    }

    //Scenario: Login to <Robert> account with correct email and Delete account
    //***********************************************************************************************************

    @And("I click Delete button to delete account")
    public void i_click_delete_button_to_delete_account() {
        homePage.clickDeleteAccount();
        System.out.println(driver.getCurrentUrl());
    }

    @Then("<Robert> Account was Deleted")
    public void robert_account_was_deleted() {
        System.out.println(driver.getCurrentUrl());
    }

    //Scenario: Verify all products and product detail page
    //*********************************************************************************************************
    @When("I click to 'Products' button")
    public void i_click_to_products_button() {
//        homePage.clickProductsButton();
        homePage.clickProductsPage();
        driver.navigate().back();
        driver.navigate().forward();

    }

    @And("I verify Product page and product list are visible")
    public void i_verify_product_page_and_product_list_are_visible() {
        driver.navigate().back();
        driver.navigate().forward();
        Assertions.assertEquals("https://automationexercise.com/products", productPage.getCurrentUrl());
        Assertions.assertTrue(productPage.isListOfElementsDisplayed());
    }

    @And("I click view product of first product")
    public void i_click_view_product_of_first_product() {
        productsPage.clickViewProductFirst();

        productPage.clickFirstViewProductButton();
    }

    @Then("I am on detail page and verify ':' product name, price, availability, condition, brand")
    public void i_am_on_detail_page_and_verify_product_name_price_availability_condition_brand() {
        driver.navigate().back();
        driver.navigate().forward();
        Assertions.assertEquals("[Blue Top, Rs. 500, Availability:, Condition:, Brand:]", productPage.getProductElements());
        Assertions.assertEquals("[Blue Top, Rs. 500, Brand:, Availability:, Condition:]", productsPage.getProductElements());


    }

    //Scenario: Verify products quantity in cart
    //*********************************************************************************************************

    @And("I click view product of first")
    public void i_click_view_product_of_first() {
        homePage.clickProductsPage();
        driver.navigate().back();
        driver.navigate().forward();
        productsPage.clickViewProductFirst();


    }

    @And("I increase quantity to 4")
    public void i_increase_quantity_to_4() {
        productsPage.inputQuantityProductFirst(4);
        productPage.increaseQuantityTo4();
    }

    @And("I click 'Add to cart' button")
    public void i_click_add_to_cart_button() {
//        productsPage.clickAddToCart();
        productPage.clickAddToCartButton();
    }

    @And("I click 'Cart' button")
    public void i_click_cart_button() {
        driver.navigate().back();
        productsPage.waitForAndViewCartClick();
    }

    @And("I verify that product is displayed in Cart page")
    public void i_verify_that_product_is_displayed_in_cart_page() {
        productPage.isProductDisplayed();
        Assertions.assertEquals("Blue Top", cartPage.showProductNameInCart());
    }

//    public void i_verify_that_product_is_displayed_in_cart_page() {
//        Assertions.assertEquals("Blue Top",
//                cartPage.showProductNameInCart());
//    }

    @Then("I verify  exact quantity in cart")
    public void i_verify_exact_quantity_in_cart() {
        Assertions.assertEquals("4", productPage.actualQuantity());
        Assertions.assertEquals("4", cartPage.showQuantityInCart());
    }

    //Scenario: Verify Test Cases page
    //*********************************************************************************************************
    @When("I click on 'Test Cases' button")
    public void i_click_on_test_cases_button() {
        homePage.clickTestCaseButton();
        homePage.clickTestCasesPage();
        driver.navigate().back();
        driver.navigate().forward();
    }

    @Then("I verify that Test Cases page is displayed")
    public void i_verify_that_test_cases_page_is_displayed() {
        driver.navigate().back();
        driver.navigate().forward();
        Assertions.assertEquals("https://automationexercise.com/test_cases", testCasesPage.getCurrentUrl());
        Assertions.assertEquals("https://automationexercise.com/test_cases", testCasesPage.getCurrentUrl());
        ;

    }

    //Scenario: Search product
    //*********************************************************************************************************
    @And("I enter product name and click search button")
    public void i_enter_product_name_and_click_search_button() {

    }

    @And("I verify that searched products are visible")
    public void i_verify_that_searched_products_are_visible() {

    }

    //Scenario: Add products in cart
    //*********************************************************************************************************@And("I click to 'Products' button")


    @And("I hover over first product and click 'Add to cart'")
    public void i_hover_over_first_product_and_click_add_to_cart() {
        productsPage.moveToProductSlotFirst();
        productsPage.clickAddToCartProductFirst();
    }

    @And("I click 'Continue shopping' button")
    public void i_click_continue_shopping_button() {
        productsPage.clickContinueShopping();
    }

    @And("I hover over second product and click 'Add to cart'")
    public void i_hover_over_second_product_and_click_add_to_cart() {
        productsPage.moveToProductSlotSecond();
        productsPage.clickAddToCartProductSecond();
    }

    //Scenario: Remove Products from cart
    //*********************************************************************************************************
    @And("I click 'X' button for remove product from cart")
    public void i_click_x_button_for_remove_product_from_cart() {

    }

    @And("I verify that product removed from cart")
    public void i_verify_that_product_removed_from_cart() {

    }

    //Scenario: Order Product: Register and Login  before purchase
    //*********************************************************************************************************
    @And("I click Proceed to checkout")
    public void i_click_proceed_to_checkout() {

    }

    @And("I verify Address Details and Review my Order")
    public void i_verify_address_details_and_review_my_order() {

    }

    @And("I enter description in comment text area and click 'Place Order'")
    public void i_enter_description_in_comment_text_area_and_click_place_order() {

    }

    @And("I  enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void i_enter_payment_details_name_on_card_card_number_cvc_expiration_date() {

    }

    @And("I  click 'Pay and Confirm Order' button")
    public void i_click_pay_and_confirm_order_button() {

    }

    @And("I verify success message 'Your order has been placed successfully!'")
    public void i_verify_success_message_your_order_has_been_placed_successfully() {

    }

}








