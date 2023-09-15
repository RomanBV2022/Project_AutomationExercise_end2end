package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    final WebDriver driver;
    @FindBy(xpath = "//*[@id='id_gender1']")
    WebElement genderMrCheckBox;
    @FindBy(xpath = "//*[@id='password']")
    WebElement passwdInputField;
    @FindBy(xpath = "//*[@id='uniform-days']")
    WebElement daysDDlist;
    @FindBy(xpath = "//*[@id='days']/option[11]")
    WebElement dayValue;
    @FindBy(xpath = "//*[@id='uniform-months']")
    WebElement monthsDDlist;
    @FindBy(xpath = "//*[@id='months']/option[6]")
    WebElement monthValue;
    @FindBy(xpath = "//*[@id='years']")
    WebElement yearsDDlist;
    @FindBy(xpath = "//*[@id='years']/option[68]")
    WebElement yearValue;
    @FindBy(xpath = "//*[@id='newsletter']")
    WebElement newsletterCheckBox;
    @FindBy(xpath = "//*[@id='optin']")
    WebElement offerCheckBox;
    @FindBy(xpath = "//*[@id='first_name']")
    WebElement first_nameInputField;
    @FindBy(xpath = "//*[@id='last_name']")
    WebElement last_nameInputField;
    @FindBy(xpath = "//*[@id='address1']")
    WebElement address1InputField;
    @FindBy(xpath = "//*[@id='country']")
    WebElement countryDDlist;
    @FindBy(xpath = "//*[@id='country']/option[2]")
    WebElement countryValue;
    @FindBy(xpath = "//*[@data-qa='state']")
    WebElement stateInputField;
    @FindBy(xpath = "//*[@id='city']")
    WebElement citiInputField;
    @FindBy(xpath = "//*[@id='zipcode']")
    WebElement zipcodeInputField;
    @FindBy(xpath = "//*[@id='mobile_number']")
    WebElement phoneInputField;
    @FindBy(xpath = "//*[@data-qa='create-account']")
    WebElement createAccButton;
    @FindBy(xpath = "//*[@data-qa='name'")
    WebElement userName;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void titleSelect() {
        genderMrCheckBox.click();
    }

    public void passwdInput() {
        passwdInputField.sendKeys("qwerty");
    }

    public void daySelect() {
        daysDDlist.click();
        dayValue.click();

    }

    public void monthSelect() {
        monthsDDlist.click();
        monthValue.click();
    }

    public void yearSelect() {
        yearsDDlist.click();
        yearValue.click();
    }

    public void newsletterClick() {
        newsletterCheckBox.click();
    }

    public void offerClick() {
        offerCheckBox.click();
    }

    public void first_nameInput() {
        first_nameInputField.sendKeys("John");
    }

    public void last_nameInput() {
        last_nameInputField.sendKeys("Wick");
    }

    public void addressInput() {
        address1InputField.sendKeys("Any street 5 - 6");
    }

    public void countrySelect() {
        countryDDlist.click();
        countryValue.click();
    }

    public void stateInput() {
        stateInputField.sendKeys("Texas");
    }

    public void cityInput() {
        citiInputField.sendKeys("Dallas");
    }

    public void zipcodeInput() {
        zipcodeInputField.sendKeys("12543");
    }

    public void phoneInput() {
        phoneInputField.sendKeys("+132978987");
    }

    public void createAccButtonClick() {

        createAccButton.submit();
    }


}
