package testcases;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RestApi {
	
	


	    @Test(priority = 1)
	    public void testGetEmployees() {
		        Response response = RestAssured.given()
		                .get("https://dummy.restapiexample.com/api/v1/employees");
	
		        Assert.assertEquals(response.getStatusCode(), 200);
	
		        List<String> employeeNames = response.jsonPath().getList("data.employee_name");
		        System.out.println("Total number of employees: " + employeeNames.size());
		        System.out.println("Employee names: " + employeeNames);
	    }

	    @Test(priority = 2)
	    public void testCreateEmployees() {
	        // Create employee 1
	        String requestBody1 = "{\"name\":\"John Doe\",\"salary\":\"20000\",\"age\":\"30\"}";
	        Response response1 = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .body(requestBody1)
	                .post("https://dummy.restapiexample.com/api/v1/create");

	        Assert.assertEquals(response1.getStatusCode(), 200);

	        // Create employee 2
	        String requestBody2 = "{\"name\":\"Jane Smith\",\"salary\":\"30000\",\"age\":\"25\"}";
	        Response response2 = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .body(requestBody2)
	                .post("https://dummy.restapiexample.com/api/v1/create");

	        Assert.assertEquals(response2.getStatusCode(), 200);
	    }

	    @Test(priority = 3)
	    public void testUpdateEmployeeSalary() {
	        // Get the ID of the first employee created in the previous test
	        Response response = RestAssured.given()
	                .get("https://dummy.restapiexample.com/api/v1/employees");

	        Assert.assertEquals(response.getStatusCode(), 200);

	        int employeeId = response.jsonPath().getInt("data[0].id");

	        // Update the salary of the first employee created
	        Response updateResponse = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .body("{\"salary\":\"30000\"}")
	                .put("https://dummy.restapiexample.com/api/v1/update/" + employeeId);

	        Assert.assertEquals(updateResponse.getStatusCode(), 200);

	        // Get the updated employee record and verify the salary has been updated
	        Response getResponse = RestAssured.given()
	                .get("https://dummy.restapiexample.com/api/v1/employee/" + employeeId);

	        Assert.assertEquals(getResponse.getStatusCode(), 200);

	        int updatedSalary = getResponse.jsonPath().getInt("data.employee_salary");
	        Assert.assertEquals(updatedSalary, 30000);
	    }

	    @Test(priority = 4)
	    public void testDeleteEmployee() {
	        // Get the ID of the second employee created in the testCreateEmployees() test
	        Response response = RestAssured.given()
	                .get("https://dummy.restapiexample.com/api/v1/employees");

	        Assert.assertEquals(response.getStatusCode(), 200);

	        int employeeId = response.jsonPath().getInt("data[1].id");

	        // Delete the second employee created
	        Response deleteResponse = RestAssured.given()
	                .delete("https://dummy.restapiexample.com/api/v1/delete/" + employeeId);

	        Assert.assertEquals(deleteResponse.getStatusCode(), 200);

	        // Get the deleted employee record and verify it returns a 404 status code
	        Response getResponse = RestAssured.given()
	                .get("https://dummy.restapiexample.com/api/v1/employee/" + employeeId);





	    }}
