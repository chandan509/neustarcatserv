package com.nuestar.neustarcatserv.controller;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nuestar.neustarcatserv.constants.AppConstants;

public class CategoryResourceImplTest {
	@BeforeClass
    public static void setup() {
		//RestAssured.port = Integer.valueOf(8083);        
        RestAssured.basePath = "/neustarcatserv/";        
        //RestAssured.baseURI = "http://localhost";
        RestAssured.baseURI = "https://nuestar-task.cfapps.io";
    }
	
	@Test
	public void addCategoryTest(){
		Map<String, String> map = new HashMap<>();
		map.put("name", "PERSON");
		RestAssured.given().contentType(AppConstants.APPLJSON)
		.body(map)
		.when()
		.post("/categories").then().statusCode(200);
	}
	
	@Test
	public void removeCategoryTest(){
		Map<String, String> map = new HashMap<>();
		map.put("name", "PERSON");
		RestAssured.given().contentType(AppConstants.APPLJSON)
		.body(map)
		.when()
		.delete("/categories").then().statusCode(200);
	}

	@Test
	public void getAllCategoryPingTest(){
		RestAssured.given().when().get("/categories").then().statusCode(200);
	}
	
	@Test
	public void getAllCategoryResponseTest(){
		RestAssured.given().when().get("/categories").then()
		.body(containsString("PERSON"))
		.body(containsString("PLACE"))
		.body(containsString("ANIMAL"))
		.body(containsString("COMPUTER"))
		.body(containsString("OTHER"));
	}

}
