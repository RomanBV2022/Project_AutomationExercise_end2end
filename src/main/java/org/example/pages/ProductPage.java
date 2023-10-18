package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductPage {

    final WebDriver driver;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(xpath = "//a[@href = '/product_details/1']")
    WebElement firstViewProduct;
    @FindBy(xpath = "//div[@class='overlay-content']//a[@data-product-id='1']")
    WebElement firstAddToCart;

    @FindBy(xpath = "//a[@href = '/product_details/4']")
    WebElement fourthViewProduct;
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
    @FindBy(xpath = "//div[@class = 'features_items']")
    WebElement listOfElements;
    @FindBy(xpath = "//h2[text() = 'Blue Top']")
    WebElement nameOfProduct;
    @FindBy(xpath = "//span[text() = 'Rs. 500']")
    WebElement priceOfProduct;
    @FindBy(xpath = "//b[text() = 'Availability:']")
    WebElement availabilityOfProduct;
    @FindBy(xpath = "//b[text() = 'Condition:']")
    WebElement conditionOfProduct;
    @FindBy(xpath = "//b[text() = 'Brand:']")
    WebElement brandOfProduct;
    @FindBy(xpath = "//input[@id=\"search_product\"]")
    WebElement searchInputField;
    @FindBy(xpath = "//button[@id='submit_search]")
    WebElement searchButton;
    @FindBy(xpath = "//div[@class=\"productinfo text-center\"]//p")
    List<WebElement> productElements;


            //Methods
            public void clickFirstViewProductButton(){
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", firstViewProduct);
        firstViewProduct.click();
}

    public void increaseQuantityTo4() {
        driver.navigate().back();
        driver.navigate().forward();
        quantityField.clear();
        quantityField.sendKeys("4");
    }

    public void clickAddToCartButton() {
        Actions action = new Actions(driver);
        action.scrollToElement(fourthViewProduct).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        firstViewProduct.click();
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

    public void isProductDisplayed() {
        Assertions.assertTrue(firstViewProduct.isDisplayed());
    }

    public String actualQuantity() {
        return actualQuantity.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isListOfElementsDisplayed() {
        return listOfElements.isDisplayed();
    }

    public String getProductElements() {
        ArrayList<String> list = new ArrayList<>();
        list.add(nameOfProduct.getText());
        list.add(priceOfProduct.getText());
        list.add(availabilityOfProduct.getText());
        list.add(conditionOfProduct.getText());
        list.add(brandOfProduct.getText());
        return list.toString();
    }

    public void searchProduct() {
        searchInputField.clear();
        searchInputField.sendKeys("women");
        searchButton.click();
    }

    public boolean showSearchElements() {
     for(WebElement element : productElements){
         if(!element.getText().contains("women")){
             return false;
         }

     }
     return true;
    }
    public String getTextFirstProduct(){
                return firstViewProduct.getText();
    }


}