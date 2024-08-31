package com.shakib1729.stocks_api.stocks;

import jakarta.persistence.Embeddable;

@Embeddable
public class StockWithQuantity {

	private String stock;

	private float quantity;

	private double totalAmount;

	public StockWithQuantity() {
	}

	public StockWithQuantity(String stock, float quantity, double totalAmount) {
		super();
		this.stock = stock;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "StockWithQuantity [stock=" + stock + ", quantity=" + quantity + ", totalAmount=" + totalAmount + "]";
	}

}
