package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiActions extends CommonOps {
     // This function returns the response body (which is why it is not void)
    @Step("Get Data From Server")

    public static Response get(String paramsValues){
        response=httpRequest.get(paramsValues);
        response.prettyPrint();
        return response;
    }

    // We want to extract a value from the JSON response
    @Step("Extract Value From JSON Format")
    public static String extractFromJSON(Response response, String path){
        jp=response.jsonPath();  // Convert the response to JSON so that we can extract data from it
        return jp.get(path).toString();// The path parameter specifies the layers within the JSON file from which we extract the desired data,
        // which we then convert to a String

    }



    @Step("Post Data To Server")
    public static void post(JSONObject params, String resource){
        httpRequest.header("Content-Type","application/json"); // To add a new record, we must set the request header specifying JSON content type
        httpRequest.body(params.toJSONString()); // Provide the parameters to send in the request body
        response=httpRequest.post(resource); // The resource is the endpoint where the request is sent
        response.prettyPrint();
    }


    @Step("Update Data From Server")
    public static void put(JSONObject params, String resource){
        httpRequest.header("Content-Type","application/json"); // Setting the request header to JSON for updating a record
        httpRequest.body(params.toJSONString()); // // Providing the parameters to update in the request body
        response=httpRequest.put(resource); // The resource is the endpoint for deleting the record by id
        response.prettyPrint();
    }

    @Step("Delete Data From Server")
    public static void delete(String id){
        response=httpRequest.delete("/delete/"+id); // The resource is the endpoint for deleting the record by id
        response.prettyPrint();
    }



}
