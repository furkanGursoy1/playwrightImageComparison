package example;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"},
        publish = true,
        monochrome = true,
        features = "src/test/resources/features",
        glue = "example",
        dryRun = false,
        tags = "@reg"
)public class RunCucumberTest {
}

