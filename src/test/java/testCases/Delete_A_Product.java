package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
//import java.util.concurrent.TimeUnit;
public class Delete_A_Product {

	@Test
	
	public void Delete_A__Product() {
		
//https://techfios.com/api-prod/api/product/delete.php
		
		HashMap payload = new HashMap();
	//	payload.put("id", "1313")
	//	payload.put("name", "New Laptop" );
	//	payload.put("description", "Not a apple product" );
	//	payload.put("price", "" );
	//	payload.put("category_id", "2" );
	//	payload.put("category_name", "Electronics" );
		
		Response response=
		given()
	//	.log().all()
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type","application/json;charset=UTF-8")
		.body(payload)
		.when()
		.delete("/delete.php")
		.then()
		
		.extract().response();
	
	
		
		
	String responseBody = response.getBody().asString();
		
	//	System.out.println(responseBody);
		
   //Parsing responseBody to Json:
		
	JsonPath js = new JsonPath(responseBody);
	js.prettyPrint();
	
		
   //String productId = js.get("id");
	String productname = js.getString("name");
//	String productdescription = js.getString("description");
		
	//Assert.assertEquals(productId, "1285");
	//Assert.assertEquals(productname, "New Laptop");
	//Assert.assertEquals(( productdescription, "");
		
	
	
	
		
		
		
		
		
	
			
		}
		
		
	}

