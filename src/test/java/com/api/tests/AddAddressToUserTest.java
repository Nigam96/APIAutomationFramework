package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.PatchProfileRequest;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserManagementResponse;

import io.restassured.response.Response;


@Listeners(com.api.listners.Testlistners.class)
public class AddAddressToUserTest extends BaseTest{
	
   
	@Test
	public void addAddressToUserTest() {
	
		AuthService authService=new AuthService();
		Response response=authService.login(new LoginRequest(config.getProperty("userName"),config.getProperty("password")));
		String token=response.as(LoginResponse.class).getToken();
		System.out.println(response.asPrettyString());
		
        UserManagementService userManagementService=new UserManagementService();
        response= userManagementService.getProfile(token);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.as(UserManagementResponse.class).getUsername(), config.getProperty("userName"));
        
        
        PatchProfileRequest patchProfileRequest=new PatchProfileRequest.Builder()
				.firstName(config.getProperty("firstName"))
				.lastName(config.getProperty("lastName"))
				.email(config.getProperty("email"))
				.mobileNumber(config.getProperty("mobileNumber"))
				.address(config.getProperty("address"))
				.build();
        response=userManagementService.patchProfile(patchProfileRequest, token);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.asPrettyString());
        }
}
