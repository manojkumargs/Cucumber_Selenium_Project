package StepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="Features",glue= {"StepDefinitions"},
monochrome=true,
plugin= {"pretty","html:target/html_report","json:target/jsonreport"})
public class Test_Runner extends AbstractTestNGCucumberTests{

}
