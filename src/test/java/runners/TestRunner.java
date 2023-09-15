package runners;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.managers.PageObjectManager;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.example.managers.WebDriverSetup.initializeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/new_account_create.feature",
        glue = {"tests/stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner {

}
