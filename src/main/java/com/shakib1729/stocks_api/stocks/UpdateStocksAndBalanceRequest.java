package com.shakib1729.stocks_api.stocks;

import java.util.List;

public class UpdateStocksAndBalanceRequest {

	private List<StockWithQuantity> stocks;
	private double balance;

	public UpdateStocksAndBalanceRequest(List<StockWithQuantity> stocks, double balance) {
		super();
		this.stocks = stocks;
		this.balance = balance;
	}

	public List<StockWithQuantity> getStocks() {
		return stocks;
	}

	public void setStocks(List<StockWithQuantity> stocks) {
		this.stocks = stocks;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "UpdateStocksAndBalanceRequest [stocks=" + stocks + ", balance=" + balance + "]";
	}

}
