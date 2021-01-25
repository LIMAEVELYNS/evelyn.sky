package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty" , features = "src/test/java/features", glue = "", tags = {
"@Programacoes" }, monochrome = true, snippets = SnippetType.CAMELCASE, dryRun = false, strict = false)

public class Runner {

}
