package com.test.stepDefination;

import static io.restassured.RestAssured.given;
import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;
import com.test.RestFullBooker.RestBody;

public class PutValidation {

	public HashMap<String, Object> getHeaderMap() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("firstname", "Mark");
		hashMap.put("lastname", "polo");
		hashMap.put("totalprice", RestBody.getTotalPrice());
		hashMap.put("depositpaid", RestBody.getdepositepaid());
		HashMap<String, String> bookingDateMap = new HashMap();
		bookingDateMap.put("checkin", "2023-01-01");
		bookingDateMap.put("checkout", "2024-01-01");
		hashMap.put("bookingdates", bookingDateMap);
		return hashMap;
	}

	public HashMap<String, String> getUserData() {
		HashMap<String, String> authentication = new HashMap<String, String>();
		authentication.put("username", "admin");
		authentication.put("password", "password123");
		return authentication;
	}

	public String getToken() {
		String response = 
		 given().body(getUserData()).contentType("application/json").when()
				.post("https://restful-booker.herokuapp.com/auth").then().extract().response().asString();
		JSONObject jsonObject = new JSONObject(response);
		return (String) jsonObject.get("token");
	}

	@Test
	public void validatePut() {
		given()
		.body(getHeaderMap())
		.cookie("token", getToken())
		.contentType("application/json").when()
				.put("https://restful-booker.herokuapp.com/booking/121").
			then().statusCode(200).log().all();
	}

}
