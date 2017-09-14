package com.libertymutual.goforcode.invoicify.models;

public class FlatFeeBillingRecords extends BillingRecord {

	private double amount;

	public double getTotal() {
		return amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
