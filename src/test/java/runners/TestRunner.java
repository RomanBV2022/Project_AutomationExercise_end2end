package runners;


import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.managers.WebDriverSetup;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.example.managers.WebDriverSetup.initializeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/new_account_create.feature",
        glue = {"org/example/stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner {
//    WebDriver driver;
//    @BeforeAll
//    public static void setDriver(WebDriver driver){
//         driver = initializeDriver();
//    }
//    @AfterAll
//    public static void closeDriver(WebDriver driver){
//        driver.quit();
//    }
}
