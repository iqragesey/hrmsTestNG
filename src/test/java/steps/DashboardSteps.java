package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps {

    @Then("verify the following tabs on dashboard")
    public void verify_the_following_tabs_on_dashboard(DataTable dataTable) {

        List<String> expectedTabs=dataTable.asList();

        DashboardPage dash=new DashboardPage();
        List<String> actualTabs=new ArrayList<>();
        for (WebElement ele:dash.dashboardtabs
        ) {
            actualTabs.add(ele.getText());
        }
        System.out.println(expectedTabs);
        System.out.println(actualTabs);
        Assert.assertTrue(expectedTabs.equals(actualTabs));
        System.out.println("My test case is passed");
    }


}
