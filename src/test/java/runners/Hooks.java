package runners;

import io.cucumber.java.BeforeAll;
import org.example.managers.WebDriverSetup;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @BeforeAll
    public static void setDriver(){
        WebDriver driver = WebDriverSetup.initializeDriver();
    }
}
