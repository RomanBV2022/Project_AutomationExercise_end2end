package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/account_management.feature",
        glue = {"/tests/stepsDefinitions"},
        plugin = {"pretty", "html:/cucumber-html-report/cucumber-report.html","json:/cluecumber/cucumber-json-report/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class StartTests {

}
