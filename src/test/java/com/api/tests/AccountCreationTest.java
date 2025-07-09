package com.api.tests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

@Listeners(com.api.listners.Testlistners.class)
public class AccountCreationTest extends BaseTest{
	
	@Test(description = " Verify if Login API is working...")

	public void createAccountTest() {
		
		SignUpRequest signUpRequest=new SignUpRequest.Builder()
		.userName(config.getProperty("userName"))
		.email(config.getProperty("email"))
		.firstName(config.getProperty("firstName"))
		.password(config.getProperty("password"))
		.lastName(config.getProperty("lastName"))
		.mobileNumber(config.getProperty("mobileNumber"))
		.build();
		
		
		AuthService authService = new AuthService();
		Response response=authService.signUp(signUpRequest);
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);

	}
}
