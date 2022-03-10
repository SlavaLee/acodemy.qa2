package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"step_definitions", "hooks"},
        plugin = {"pretty", "json:report.json"}
)

public class RunCucumberTest {

}
