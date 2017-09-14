package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.meanbean.test.BeanTester;


public class FlatFeeBillingRecordTests {

	@Test
	public void test_all_gets_and_sets_for_flat_fee_billing() {
		new BeanTester().testBean(FlatFeeBillingRecords.class);
	}
	
	
	@Test
	public void test_getTotal_returns_amount() {
		
		//Arrange
		FlatFeeBillingRecords flatFeeBillingRecord = new FlatFeeBillingRecords();
		double amount = 4;
		//Act
		flatFeeBillingRecord.setAmount(amount);
		//Assert
	 	assertThat(flatFeeBillingRecord.getTotal()).isEqualTo(amount);
	}
	
}

