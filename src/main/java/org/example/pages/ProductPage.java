package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    final WebDriver driver;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//a[@href = '/product_details/1']")
    WebElement firstViewProduct;
    @FindBy(xpath = "//input[@name = 'quantity']")
    WebElement quantityField;
    @FindBy(xpath = "//button[@class = 'btn btn-default cart']")
    WebElement buttonAddToCart;
    @FindBy(xpath = "//a[@href = '/view_cart']/u")
    WebElement viewCartLink;
    @FindBy(xpath = "//button[@class= 'disabled']")
    WebElement actualQuantity;
    @FindBy(xpath = "//div[@id = 'dismiss-button']")
    WebElement advertDismissButton;


    //Methods
    public void clickFirstViewProductButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", firstViewProduct);
        firstViewProduct.click();
    }

    public void increaseQuantityTo4(){
        driver.navigate().back();
        driver.navigate().forward();
        quantityField.clear();
        quantityField.sendKeys("4");
    }

    public void clickAddToCartButton(){
        buttonAddToCart.click();
    }
    public void clickViewCartLink() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        viewCartLink.click();
    }
    public void isProductDisplayed(){
        Assertions.assertTrue(firstViewProduct.isDisplayed());
    }
    public String actualQuantity(){
        return actualQuantity.getText();
    }
}
