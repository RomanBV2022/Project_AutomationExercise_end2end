package org.example.managers;

import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public PageObjectManager(HomePage homePage) {
        this.homePage = homePage;
    }


    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }


}
