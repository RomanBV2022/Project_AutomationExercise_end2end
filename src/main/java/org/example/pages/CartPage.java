package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td/h4/a")
    WebElement productNameInCart_xpath;

    @FindBy(xpath = "//button[@class='disabled']")
    WebElement quantityProductInCart_xpath;

    public String showProductNameInCart() {
        return productNameInCart_xpath.getText();

    }

    public String showQuantityInCart() {
        return quantityProductInCart_xpath.getText();
    }
}