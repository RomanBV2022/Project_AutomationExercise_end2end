package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:reports/cucumber-reports.html", "json:reports/cucumber-json-report/cucumber.json"}
)
public class TestRunner {

}