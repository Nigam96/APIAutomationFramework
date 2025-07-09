package com.api.base;

import static io.restassured.RestAssured.given;
import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URI="http://64.227.160.186:8080";
	private RequestSpecification reqSpec;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	public BaseService() {
		this.reqSpec=given().baseUri(BASE_URI);
	}
	protected Response postRequest(Object payload,String endpoint) {
		return reqSpec.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	protected void getAuthToken(String token) {
		reqSpec.header("Authorization","Bearer "+token);
	}
	protected Response getRequest(String endpoint) {
		return reqSpec.get(endpoint);
	}
	protected Response getRequest(String endpoint,String token) {
		return reqSpec.header("Authorization","Bearer "+token).get(endpoint);
	}
	protected Response updateRequest(String endpoint,Object payload,String token) {
		return reqSpec.header("Authorization","Bearer "+token).contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	
	protected Response patchRequest(String endpoint,Object payload,String token) {
		return reqSpec.header("Authorization","Bearer "+token).contentType(ContentType.JSON).body(payload).patch(endpoint);
	}
}
