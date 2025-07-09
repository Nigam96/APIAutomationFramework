package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;
import java.util.HashMap;
import java.util.Map;
import io.restassured.response.Response;

public class AuthService extends BaseService	{
private String BASE_PATH="/api/auth/";

public Response login(LoginRequest payload) {
	return postRequest(payload, BASE_PATH+"login");
}
public Response signUp(SignUpRequest payload) {
	return postRequest(payload,BASE_PATH+"signup");
}
public Response forgotPassword(String emailAddress) {
	HashMap<String,String> payload=new HashMap<String,String>();
	payload.put("email", "emailAdress");
	return postRequest(emailAddress,BASE_PATH+"/forgot-password");
}
}
