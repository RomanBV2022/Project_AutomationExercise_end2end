package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public class ProductsPage {
    final WebDriver driver ;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href=\"/product_details/1\"]/i[@class='fa fa-plus-square']")
    WebElement viewProductFirst_xpath;

    @FindBy(xpath = "//*[@name=\"quantity\"]")
    WebElement inputQuantityProductFirst_xpath;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    WebElement addTocart_xpath;

    @FindBy(xpath = "//li/a[@href='/view_cart']")
    WebElement viewCart_xpath;

    @FindBy(xpath = "//div[@class='features_items']")
    WebElement listOfElements_xpath;

    @FindBy(xpath = "//h2[text()='Blue Top']")
    WebElement nameOfProducts;

    @FindBy(xpath = "//span[text()='Rs. 500']")
    WebElement priceOfProducts;

    @FindBy(xpath = "//b[text()='Availability:']")
    WebElement availabilityOfProducts;

    @FindBy(xpath = "//b[text()='Condition:']")
    WebElement conditionOfProducts;

    @FindBy(xpath = "//b[text()='Brand:']")
    WebElement brandOfProducts;

    public void waitForAndViewCartClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement viewCartElement = wait.until(ExpectedConditions.visibilityOf(viewCart_xpath));
        viewCartElement.click();
    }

    public void clickViewProductFirst() {
        viewProductFirst_xpath.click();
    }

    public void inputQuantityProductFirst(int i) {
        inputQuantityProductFirst_xpath.clear();
        inputQuantityProductFirst_xpath.sendKeys(Integer.toString(i));
    }

    public void clickAddToCart() {
          addTocart_xpath.click();
    }

    public String getCurrentUrl(){ return driver.getCurrentUrl();}

    public boolean isListOfElementsDisplayed(){
        return listOfElements_xpath.isDisplayed();
    }

    public String getProductElements(){
        ArrayList<String> list =new ArrayList<>();
        list.add(nameOfProducts.getText());
        list.add(priceOfProducts.getText());
        list.add(brandOfProducts.getText());
        list.add(availabilityOfProducts.getText());
        list.add(conditionOfProducts.getText());
        return list.toString();
    }
}
