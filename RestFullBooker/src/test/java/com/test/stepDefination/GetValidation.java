package com.test.stepDefination;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.test.RestFullBooker.Config;

public class GetValidation extends Config {

	public WebDriver driver;

	@Test(enabled = false)
	public void postAuthenticationValidation() {
		
		Map<String,String> authPayload = new HashMap<String,String>();
		authPayload.put("username", "admin");
		authPayload.put("password", "password123");
		
		
		given().auth().basic("admin", "password123")
			.body(authPayload)
		.when()
		.post("https://restful-booker.herokuapp.com/auth")
		.then()
				.log().all();

	}

	@Test(enabled = false)
	public void getValidate() {
		given().when().get("https://restful-booker.herokuapp.com/booking?firstname=Eric&lastname=Smith").then()
				.statusCode(200).log().all().assertThat().statusCode(200);
	}

	@Test(enabled = false)
	public void validateByName() {
		given().when().get("https://restful-booker.herokuapp.com/booking?firstname=Eric&lastname=Ericsson").then()
				.statusCode(200).log().all();
	}

	@Test
	public void validateResultSet() {
		given().when().get("https://restful-booker.herokuapp.com/booking/2").then().statusCode(200).body("firstname",
				equalTo("Mark"));
	}
}
