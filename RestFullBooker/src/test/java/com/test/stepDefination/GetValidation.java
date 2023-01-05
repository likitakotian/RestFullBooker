package com.test.stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.test.RestFullBooker.Config;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetValidation extends Config {

	public WebDriver driver;

	@Test(enabled = false)
	public void postAuthenticationValidation() {
		given().auth().basic("admin", "password123").when().post("https://restful-booker.herokuapp.com/auth").then()
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
