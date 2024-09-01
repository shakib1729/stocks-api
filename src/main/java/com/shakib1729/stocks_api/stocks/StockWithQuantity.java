package com.shakib1729.stocks_api.stocks;

import jakarta.persistence.Embeddable;

@Embeddable
public class StockWithQuantity {

	private String symbol;

	private float quantity;

	private double investedAmount;

	public StockWithQuantity() {
	}

	public StockWithQuantity(String symbol, float quantity, double investedAmount) {
		super();
		this.symbol = symbol;
		this.quantity = quantity;
		this.investedAmount = investedAmount;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public double getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}

	@Override
	public String toString() {
		return "StockWithQuantity [symbol=" + symbol + ", quantity=" + quantity + ", investedAmount=" + investedAmount
				+ "]";
	}

}
