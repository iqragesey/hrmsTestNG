package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.math3.analysis.function.Add;
import pages.AddEmployeePage;
import pages.DashboardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods{

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashboardPage dash = new DashboardPage();
        click(dash.pimOPtion);
    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        DashboardPage dash = new DashboardPage();
        click(dash.addEmployeeButton);

    }
    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, "iqraa");
        sendText(add.middleName, "");
        sendText(add.lastName, "ggg");
    }
        @When("user enters first name {string} middle name {string} and last name {string}")
        public void user_enters_first_name_middle_name_and_last_name(String firstName, String middleName, String lastName) {
            AddEmployeePage add = new AddEmployeePage();
            sendText(add.firstName, firstName);
            sendText(add.middleName, middleName);
            sendText(add.lastName, lastName);
        }

    @When("user enters {string} {string} and {string} in the application")
    public void user_enters_and_in_the_application(String FirstName, String MiddleName, String LastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, FirstName);
        sendText(add.middleName, MiddleName);
        sendText(add.lastName, LastName);

    }


    @When("user clicks on save button option")
    public void user_clicks_on_save_button_option() {
        AddEmployeePage add = new AddEmployeePage();
        click(add.saveBtn);

    }
    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("Employee added successfully");

    }

    @When("add multiple employees and verify they're added successfully")
    public void add_multiple_employees_and_verify_they_re_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeNames = employees.asMaps();
        for(Map<String, String> employeename: employeeNames){

            String firstnamevalue = employeename.get("FirstName");
            String middlenamevalue = employeename.get("MiddleName");
            String lastnamevalue = employeename.get("LastName");
            System.out.println(firstnamevalue+" "+middlenamevalue+" "+lastnamevalue);

            AddEmployeePage addEP = new AddEmployeePage();
            sendText(addEP.firstName, firstnamevalue);
            sendText(addEP.middleName, middlenamevalue);
            sendText(addEP.lastName, lastnamevalue);
            click(addEP.saveBtn);

            //implement assertion as HW

            Thread.sleep(4000);
            DashboardPage dash = new DashboardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(4000);

        }

    }
    @When("user adds multiple employees from excel file from {string} sheet and verify they are added")
    public void user_adds_multiple_employees_from_excel_file_from_sheet_and_verify_they_are_added(String sheetname) throws InterruptedException {
        List<Map<String, String>> newemployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetname);

        DashboardPage dash = new DashboardPage();
        AddEmployeePage addEmp = new AddEmployeePage();

        Iterator<Map<String, String>> it = newemployees.iterator();
        while(it.hasNext()){

            Map<String, String> mapNewEmp = it.next();
            sendText(addEmp.firstName, mapNewEmp.get("FirstName"));
            sendText(addEmp.middleName, mapNewEmp.get("MiddleName"));
            sendText(addEmp.lastName, mapNewEmp.get("LastName"));
            click(addEmp.saveBtn);
            //assertion do for HW


        }



    }


}
