package org.example.pages;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    final WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //locators
    @FindBy(xpath = "//input[@id=\"id_gender1\"]")
    WebElement genderMale;
    @FindBy(xpath = "//input[@data-qa=\"password\"]")
    WebElement password;
    @FindBy(xpath = "//select[@id=\"days\"]")
    WebElement days;
    @FindBy(xpath = "//select[@id=\"months\"]")
    WebElement months;
    @FindBy(xpath = "//select[@id=\"years\"]")
    WebElement years;
    @FindBy(xpath = "//input[@id=\"newsletter\"]")
    WebElement newsLetter;
    @FindBy(xpath = "//input[@id=\"optin\"]")
    WebElement offers;
    @FindBy(xpath = "//input[@id=\"first_name\"]")
    WebElement firstName;
    @FindBy(xpath = "//input[@id= \"last_name\"]")
    WebElement lastName;
    @FindBy(xpath = "//input[@id=\"company\"]")
    WebElement company;
    @FindBy(xpath = "//input[@id=\"address1\"]")
    WebElement address1;
    @FindBy(xpath = "//input[@id=\"address2\"]")
    WebElement address2;
    @FindBy(xpath = "//select[@id=\"country\"]/option[3]")
    WebElement country;
    @FindBy(xpath = "//input[@id=\"state\"]")
    WebElement state;
    @FindBy(xpath = "//input[@id=\"city\"]")
    WebElement city;
    @FindBy(xpath = "//input[@id=\"zipcode\"]")
    WebElement zipcode;
    @FindBy(xpath = "//input[@id=\"mobile_number\"]")
    WebElement mobileNumber;
    @FindBy(xpath = "//button[@data-qa=\"create-account\"]")
    WebElement buttonCreateAccount;


    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
    WebElement errorMessageEmailExists;


    //Methods
//    public void addGender() {
//        genderMale.click();
//    }
//
//    public void addPassword(String password) {
//        this.password.sendKeys(password);
//    }
//
//    public void addDay(int day) {
//        days.sendKeys(Integer.toString(day));
//
//    }

    public void addAccountInformation(String password, int day, int month, int year) {
        genderMale.click();
        this.password.sendKeys(password);
        days.sendKeys(Integer.toString(day));
        months.sendKeys(Integer.toString(month));
        years.sendKeys(Integer.toString(year));
        newsLetter.click();
        offers.click();
    }

    public void addAddressInformation(String firstName, String lastName, String company, String address1, String address2, String state, String city, int zipcode, int mobileNumber) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.company.sendKeys(company);
        this.address1.sendKeys(address1);
        this.address2.sendKeys(address2);
        this.country.click();
        this.state.sendKeys(state);
        this.city.sendKeys(city);
        this.zipcode.sendKeys(Integer.toString(zipcode));
        this.mobileNumber.sendKeys(Integer.toString(mobileNumber));
    }

    public void clickCreateAccount() {
        buttonCreateAccount.click();
    }

    public String showErrorMessageEmailExists() {
        return errorMessageEmailExists.getText();
    }


}
