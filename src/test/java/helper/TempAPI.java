package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TempAPI {

    RequestSpecification httpRequest;
    Response response;
    String url="https://dummy.restapiexample.com/api/v1";

    @Test
    public void testingAPI()
    {
        RestAssured.baseURI=url;
        httpRequest=RestAssured.given();

        // Get Request Of All Employees
      //  response=httpRequest.get("/employees");
      //  response.prettyPrint();


        // Post Request- אנחנו רוצים להוסיף עוד עובד לרשימה
        // הגדרנו אובייקט בשם params, ואליו אנחנו מכניסים נתונים שאנחנו רוצים לעדכן
        JSONObject params = new JSONObject();
        params.put("name", "Simona-bar");
        params.put("salary", "17000");
        params.put("age", "39");
       // params.put("id", "78");

        httpRequest.header("Content-Type", "application/json"); //מגדירים לו את הכותרת של הבקשה שזה קובץ מסוג גייסון


        httpRequest.body(params.toJSONString());// האובייקט paramsנכנס עכשיו לגוף הבקשה מסוג קובץ גייסון
        response = httpRequest.post("/create"); // שולח את הבקשה

      //  response = httpRequest.put("/update/1"); // מעדכן בקשה

      //  response = httpRequest.delete("/delete/1"); //  מוחק רשוצה

        response.prettyPrint();
        System.out.println("----------------");
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("Status code: " + response.getStatusCode());

        String responseBody = response.getBody().asString();
        if (responseBody.trim().startsWith("{")) {
            // נראה שזו תגובת JSON - אפשר לנתח
            String id = response.jsonPath().getString("data.id");
            System.out.println("New employee ID: " + id);
        } else {
            System.out.println("❌ קיבלנו תגובה לא תקינה (לא JSON):");
            System.out.println(responseBody);
        }



    }

}
