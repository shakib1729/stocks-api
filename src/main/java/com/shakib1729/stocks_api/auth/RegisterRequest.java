package com.shakib1729.stocks_api.auth;

public class RegisterRequest {

	private String email;
	private String password;
	private String name;
	private double balance;

	public RegisterRequest(String name, String email, String password, double balance) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
