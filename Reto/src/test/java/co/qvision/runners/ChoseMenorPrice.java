package co.qvision.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src\\main\\resources\\features\\ChoseMenorPrice.feature",
        glue="co.qvision.stepDefinitions",
        snippets= SnippetType.CAMELCASE,
        monochrome = true)
public class ChoseMenorPrice {
	
}
