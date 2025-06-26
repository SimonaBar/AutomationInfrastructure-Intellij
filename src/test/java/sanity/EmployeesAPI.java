package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)

public class EmployeesAPI extends CommonOps {
    @Test(description = "Test01: Get Employee Name From Employee List")
    @Description("This Test Verifies Employee Name")
    public void test01_verifyEmployeeName() {
        Verifications.verifyText(ApiFlows.getEmployeeData("data.employee_name","1"), "Tiger Nixon");
    }



    @Test(description = "Test02: Post A New Employee To The Employee List")
    @Description(" This Test Adds A new Employee To The List And Verify ")
    public void test02_addAnewEmployeeAndVerify(){
        ApiFlows.postNewEmployee("Simona Barb","15000","39");
        Verifications.verifyText(ApiFlows.getEmployeeData("data.employee_name","25"),"Simona Barb");
    }

    @Test(description = "Test03: Update Employee Salary from Employee List")
    @Description(" This Test Updates Employees Salary  And Verify ")
    public void test03_updateEmployeeAndVerify(){
        ApiFlows.updateEmployee("Ashton Cox","1000","66","3");
       Verifications.verifyText(ApiFlows.getEmployeeData("data.employee_salary","3"),"1000");
    }

    @Test(description = "Test04: Delete Employee from Employee List")
    @Description(" This Test Delete Employee And Verify ")
    public void test04_deleteEmployeeAndVerify(){
       ApiFlows.deleteEmployee("1");
       Verifications.verifyText(ApiFlows.getEmployeeData("data.employee_name","2"),"Garrett Winters");
    }





}
