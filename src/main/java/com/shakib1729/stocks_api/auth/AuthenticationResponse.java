package com.shakib1729.stocks_api.auth;

public class AuthenticationResponse {

	private String token;

	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
