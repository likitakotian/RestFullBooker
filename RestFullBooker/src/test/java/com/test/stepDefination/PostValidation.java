package com.test.stepDefination;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.RestFullBooker.Config;
import com.test.RestFullBooker.RestBody;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;


public class PostValidation extends Config{

//	@BeforeClass
//	public void initializeURL() {
//		RestAssured.baseURI="https://restful-booker.herokuapp.com";
//		RestAssured.basePath="/booking";
//	}
	
	
	
	public HashMap<String, Object> getHeaderMap() {
		HashMap<String, Object>  hashMap = new HashMap<String, Object>();
		hashMap.put("firstname", RestBody.getFN());
		hashMap.put("lastname", RestBody.getLN());
		hashMap.put("totalprice", RestBody.getTotalPrice());
		hashMap.put("depositpaid", RestBody.getdepositepaid());
		HashMap<String, String> bookingDateMap = new HashMap();
		bookingDateMap.put("checkin", RestBody.getcheckin());
		bookingDateMap.put("checkout", RestBody.getcheckout());
		hashMap.put("bookingdates", bookingDateMap);
		return hashMap;
	}
	
	
	@Test
	public void validatePost() throws JsonProcessingException {
		given()
			.body(getHeaderMap())
			.contentType("application/json")
		.when()
			.post("https://restful-booker.herokuapp.com/booking")
		.then()
			.statusCode(200)
			.log().all();
	}
}
