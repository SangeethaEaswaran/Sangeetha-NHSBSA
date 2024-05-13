package cucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/java/features" , glue = "stepDefinitions" , monochrome= true , tags = "@RunTest", plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
// tags = "not @RunTest" ,  tags = "@RunTest or @SmokeTest"
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
