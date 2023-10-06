package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/account_management.feature",
        glue = {"/tests/stepsDefinitions"},
        plugin = {"pretty", "html:output/cucumber-report.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class StartTests {

}
