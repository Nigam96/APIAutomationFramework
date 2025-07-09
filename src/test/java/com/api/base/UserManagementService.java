package com.api.base;

import com.api.models.request.PatchProfileRequest;
import com.api.models.request.UpdateProfileRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService{
	private static final String BASE_PATH="/api/users";
	
	public Response getProfile(String token) {
//		getAuthToken(token);
		return getRequest(BASE_PATH+"/profile",token);
		 
	}
	public Response updateProfile(UpdateProfileRequest payload,String token) {
		return updateRequest(BASE_PATH+"/profile",payload,token);
	}
	public Response patchProfile(PatchProfileRequest payload,String token) {
		return patchRequest(BASE_PATH+"/profile",payload,token);
	}

}
