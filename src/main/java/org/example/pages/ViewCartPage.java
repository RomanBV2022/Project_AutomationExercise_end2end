package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage {
    final WebDriver driver;
    public ViewCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Locators
    @FindBy(xpath = "//a[@data-product-id='1']")
    WebElement buttonRemoveProduct;
    @FindBy(xpath = "//*[@id=\"empty_cart\"]/p/b")
    WebElement textIsEmpty;
    //Methods
    public void removeProduct(){
        buttonRemoveProduct.click();
    }
    public String getTextEmptyCart(){
        return textIsEmpty.getText();
    }


}
