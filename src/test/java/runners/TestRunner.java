package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/account_managment2.feature",
        glue = {"test/stepsDefinitions"},
        plugin = {"pretty", "html:output/cucumber-report.html"},
//        tags = "@smoke",
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class TestRunner {

}
