package com.libertymutual.goforcode.invoicify.models;

public class RateBasedBillingRecord extends BillingRecord {

	public double rate;
	public double quantity;

	public double getTotal() {
		double total = rate * quantity;
		return total;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
