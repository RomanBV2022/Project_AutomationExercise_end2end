package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    final WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement viewProductFirst_xpath;

      @FindBy(xpath = "//*[@name=\"quantity\"]")
    WebElement inputQuantityProductFirst_xpath;


    @FindBy(xpath = "//*[@class='btn btn-default cart']")
    WebElement addTocart_xpath;

    @FindBy(xpath = "//p/a[@href='/view_cart']")
    WebElement viewCart_xpath;


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

    public void clickViewCart() {
        viewCart_xpath.click();
    }

//    public void clickDismissAdd() {    driver.navigate().back();
//        driver.navigate().forward();}
}
