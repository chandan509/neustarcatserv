package com.nuestar.neustarcatserv.controller;

import java.util.ArrayList;
import java.util.List;


import io.restassured.RestAssured;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nuestar.neustarcatserv.constants.AppConstants;
import com.nuestar.neustarcatserv.model.Product;

public class ProcessResourceImplTest {
	@BeforeClass
    public static void setup() {
		//RestAssured.port = Integer.valueOf(8083);        
        RestAssured.basePath = "/neustarcatserv/";        
        //RestAssured.baseURI = "http://localhost";
        RestAssured.baseURI = "https://nuestar-task.cfapps.io";
    }
	
	@Test
	public void processDataTest(){
//		Map<String, String> map1 = new HashMap<>();
//		map1.put("category", "PERSON");
//		map1.put("subCategory", "Bob Jones");
//		
//		Map<String, String> map2 = new HashMap<>();
//		map2.put("category", "PERSON");
//		map2.put("subCategory", "Bob Jones");
//		
//		Map<String, String> map3 = new HashMap<>();
//		map3.put("category", "PERSON");
//		map3.put("subCategory", "Bob Jones");
		
		List<Product> list = new ArrayList<>();
		list.add(new Product("PERSON","Bob Jones"));
		list.add(new Product("PLACE","Washington"));
		list.add(new Product("PERSON","Bob Jones"));
		
		RestAssured.given().contentType(AppConstants.APPLJSON)
		.body(list)
		.when()
		.post("/process").then().statusCode(200);		
	}
	
	public void processDataResponseTest(){
		List<Product> list = new ArrayList<>();
		list.add(new Product("PERSON","Bob Jones"));
		list.add(new Product("PLACE","Washington"));
		list.add(new Product("PERSON","Bob Jones"));
		
		RestAssured.given().contentType(AppConstants.APPLJSON)
		.body(list)
		.when()
		.post("/process").then()
		.body("catGroup.PERSON", equalTo(1))
		.body("catGroup.PLACE", equalTo(1));	
	}

}
