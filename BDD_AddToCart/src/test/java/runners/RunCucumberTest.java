package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features/AddToCart.feature"},
        dryRun = !true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        glue = "addToCart",
        plugin = {"html:CucumberReports"}
)

public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
