package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserManagementResponse;

import io.restassured.response.Response;

@Listeners(com.api.listners.Testlistners.class)
public class UpdateProfileTest extends BaseTest{

	@Test
	public void updateProfileTest(){
		/*
		 * first i have to login for a user
		 * get the token 
		 * update the number of the user
		 * validate the get profile of the user with the updated number
		 */
		AuthService authService=new AuthService();
		Response response=authService.login(new LoginRequest(config.getProperty("userName"),config.getProperty("password")));
		String token=response.as(LoginResponse.class).getToken();
		
		UserManagementService userManagementService=new UserManagementService();
		response=userManagementService.getProfile(token);
		System.out.println(response.asPrettyString());
		System.out.println("---------------------------------------------------------------------");
		Assert.assertEquals(response.as(UserManagementResponse.class).getUsername(), config.getProperty("userName"));
		UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest.Builder()
				.firstName(config.getProperty("firstName"))
				.lastName(config.getProperty("lastName"))
				.email(config.getProperty("email"))
				.mobileNumber(config.getProperty("updatedMobileNumber"))
				.build();
		response=userManagementService.updateProfile(updateProfileRequest,token);
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println(response.asPrettyString());
		
		
			
		
	}
}
