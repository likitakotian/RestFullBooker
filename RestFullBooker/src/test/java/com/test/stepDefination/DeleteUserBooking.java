package com.test.stepDefination;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class DeleteUserBooking extends PutValidation{

	@Test
	public void DeleteUser() {
		given()
			.contentType("application/json")
			.body(getToken())
		.when()
			.delete(" https://restful-booker.herokuapp.com/booking/3")
		.then()
			.statusCode(200)
			.log().all();
	}
}
