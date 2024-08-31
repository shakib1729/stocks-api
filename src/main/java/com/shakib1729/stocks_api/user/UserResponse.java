package com.shakib1729.stocks_api.user;

import java.util.List;

import com.shakib1729.stocks_api.stocks.StockWithQuantity;

public class UserResponse {

	private Integer id;
	private String name;
	private String email;
	private double balance;
	private List<StockWithQuantity> stocks;

	public UserResponse(Integer id, String name, String email, double balance, List<StockWithQuantity> stocks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.stocks = stocks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<StockWithQuantity> getStocks() {
		return stocks;
	}

	public void setStocks(List<StockWithQuantity> stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", name=" + name + ", email=" + email + ", balance=" + balance + ", stocks="
				+ stocks + "]";
	}

}
