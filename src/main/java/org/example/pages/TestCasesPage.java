package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {
    final WebDriver driver;

    //constructor
    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    //Methods
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
