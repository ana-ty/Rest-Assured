package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Get_Read_All_Product {

	@Test
	
	public void read_All_Products() {
		Response response=
		given()
		.log().all()
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type","application/json;charset=UTF-8")
		
		.when()
		.get("/read.php")
		.then()

	    .statusCode(200)
		
		.extract().response();
		
		String responseBody = response.getBody().asString();
		//System.out.println(responseBody);
		
		JsonPath js = new JsonPath(responseBody);
		js.prettyPrint();
		
		int statuscode = response.getStatusCode();
		System.out.println("Status Code:"  + statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
	}
}
