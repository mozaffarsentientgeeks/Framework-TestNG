package cucumberTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumberTests", glue = "rahulShettyAcademy.stepDefinations", monochrome = true, plugin = {
		"html:cucumberReport/cucumber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
