package com.api.models.response;
import java.util.*;
public class LoginResponse {
	private String token;
	private int id;
	private String type;
	private String username;
	private String email;
	private List<String> roles;
	
	public LoginResponse() {
		
	}

	public LoginResponse(String token, int id, String type, String username, String email, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.type = type;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", id=" + id + ", type=" + type + ", username=" + username + ", email="
				+ email + ", roles=" + roles + "]";
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
