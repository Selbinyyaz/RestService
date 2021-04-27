package com.example.restservice;

import static io.restassured.RestAssured.given;


import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest
class RestServiceApplicationTests {

	@Test
	void SampleTest() {

		RestAssured.baseURI = "http://localhost:8088";
		RequestSpecification httpRequest = given().header("Content-Type", "application/json").log().all();

		Response response = httpRequest.when().get("/greeting");
		/**
		 * Pretty-print the response body if possible and return it as string. Mainly
		 * useful for debug purposes when writing tests.
		 */
		response.prettyPrint();
		/**
		 * Validating response status code is 200
		 */
		response.then().assertThat().statusCode(200);
		/**
		 * Validating Content type using then().assertthat().header()
		 */
		response.then().assertThat().header("Content-Type", "application/json");

		/**
		 * Validating Response Body
		 */

		String responseBody = response.body().asString();

		Assert.assertTrue(responseBody.contains("message"));
		Assert.assertTrue(responseBody.contains("timeStamp"));

	}

}
