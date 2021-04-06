package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class Get_Read_A_Product {

	@Test
	
	public void read_Product() {
		Response response=
		given()
		.log().all()
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type","application/json;charset=UTF-8")
		
		//  to query, parameter is given
		.queryParam("id","1209")
		.when()
		.get("/read_one.php")
		.then()

	//	.statusCode(200)
		
		.extract().response();
	//	int statuscode = response.getStatusCode();
	//	System.out.println("Status Code:"  + statuscode);
	//	Assert.assertEquals(statuscode, 200);
		
		
		String responseBody = response.getBody().asString();
		//System.out.println(responseBody);
		
		JsonPath js = new JsonPath(responseBody);
			js.prettyPrint();
		
			
			String productId = js.get("id");
			String productname = js.getString("name");
			String productdescription = js.getString("description");
			
			Assert.assertEquals(productId, "1209");
			Assert.assertEquals(productname, "HP Laptop Elite Pro");
			Assert.assertEquals( productdescription, "Super fast laptop");
			
			System.out.println("Product ID: " + productId );
		
	//	long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
	//	System.out.println("Response Time: " +responseTime);
	//	if(responseTime<=2000) {
	//		System.out.println("Response Time is in range");
	//	}else {
	//		System.out.println("Not acceptable!");
	//	}
			
		}
		
		
	}

