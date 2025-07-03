package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utilities.CommonOps;

/**
 * ApiFlows contains business logic for managing employee data
 * via REST API calls (GET, POST, PUT, DELETE).
 * Uses ApiActions to perform HTTP requests and handle responses.
 */

public class ApiFlows extends CommonOps {

    /**
     * Sends a GET request to fetch details of a specific employee by ID.
     * If the response is JSON, extracts a specific field using a JSON path.
     */

    @Step(" Business Flow: Extract Data From Employee List")
    public static String getEmployeeData(String jPath, String id) {
        response = ApiActions.get("https://dummy.restapiexample.com/api/v1/employee/" + id);

        String responseBody = response.getBody().asString(); // Print the response to check what we received
        System.out.println("Response body:\n" + responseBody);

         // Check if the response is JSON and not HTML
        if (response.getContentType().contains("application/json")) {
            // If it's JSON, extract the requested data from the JSON
            return ApiActions.extractFromJSON(response, jPath);
        } else {
            // If it's not JSON (e.g., an HTML error page), handle accordingly
            System.err.println("Received non-JSON response. Possibly rate limited.");
            return null; // Could also throw an exception here, depending on your use case
        }
    }

    /**
     * Sends a POST request to create a new employee in the system.
     */
    @Step(" Business Flow: Add New Employee To The Employee List")
    public static void postNewEmployee( String name,String salary,String age){
        params.put("name",name);
        params.put("salary",salary);
        params.put("age",age);
        ApiActions.post(params,"/create");

    }

    /**
     * Sends a PUT request to update details of an existing employee by ID.
     */

    @Step(" Business Flow: Update Employee Detail At The Employee List")
    public static void updateEmployee( String name,String salary,String age,String id){
        params.put("name",name);
        params.put("salary",salary);
        params.put("age",age);
        ApiActions.put(params,"/update/"+ id); // When updating a record, we need to specify which employee to update. This is done using their ID.
        String responseBody = response.getBody().asString();

    }
    /**
     * Sends a DELETE request to remove an employee from the system by ID.
     */
    @Step(" Business Flow: Delete Employee From The Employee List")
    public static void deleteEmployee( String id){
        ApiActions.delete(id);

    }




}
