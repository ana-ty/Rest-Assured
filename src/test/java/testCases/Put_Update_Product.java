package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
//import java.util.concurrent.TimeUnit;
public class Put_Update_Product {

	@Test
	
	public void create_Product() {
		
		HashMap payload = new HashMap();
	//	payload.put("id", "1101")
		payload.put("name", "Brand New Laptop" );
		payload.put("description", "Not a apple product" );
		payload.put("price", "1203" );
		payload.put("category_id", "2" );
		payload.put("category_name", "Electronics" );
		
		Response response=
		given()
	//	.log().all()
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type","application/json;charset=UTF-8")
		.body(payload)
		.when()
		.put("/update.php")
		.then()
		.statusCode(201)
		
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
		
	
	
	System.out.println("Status Code:"  + response.getStatusCode());
	Assert.assertEquals(response.getStatusCode(), 201);
	
		
		
		
		
		
	
			
		}
		
		
	}

