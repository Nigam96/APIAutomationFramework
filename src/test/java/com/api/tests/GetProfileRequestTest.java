package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserManagementResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest extends BaseTest{

	@Test
	public void GetProfileInfoTest() {
		AuthService authService=new AuthService();
		Response response=authService.login(new LoginRequest(config.getProperty("userName"), config.getProperty("password")));
		String token=response.as(LoginResponse.class).getToken();
		System.out.println(token);
		UserManagementService userManagementService=new UserManagementService();
		System.out.println(userManagementService.getProfile(token).as(UserManagementResponse.class).getFirstName());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
