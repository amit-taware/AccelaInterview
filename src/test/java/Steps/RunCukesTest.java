package Steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"classpath:Features/"},
        format = {"pretty", "html:target/cucumber",
                "json:target/cucumber.json"}, tags = {"@UI"})
public class RunCukesTest {

}
