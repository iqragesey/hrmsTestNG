package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/Login.feature" ,
        //glue is where we can find implementations for gherkin steps
        // we provide the path of the package for steps
        glue = "steps",
        /*if we set dryRun to true: it will quickly scan to see if all gherkin steps are implemented or not.
        if it is true, no actual execution will happen
        */
        dryRun = false,
        //monochrome means console output for the cucumber test is easily readable
        //it will remove unreadable characters
        monochrome = true,
        //if strict = true, at the time of execution, if cucumber encounters any error or
        //any undefined steps, it will give an error and stops the execution
        //it gives code snippet for the unimplemented steps
        tags = "@regression",
        //tags will identify the scenarios based on the tags we will provide such as
        //@smoke, @regression, etc.
        //we can add multiple tags in the runner class to execute scenarios that belong to different tags.
        //use and, or, "," to implement multiple
        plugin = {"html:target/cucumber-default-report.html"}

)
public class RegressionRunner {
}
