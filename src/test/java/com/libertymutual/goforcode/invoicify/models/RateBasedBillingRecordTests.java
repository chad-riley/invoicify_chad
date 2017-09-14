package com.libertymutual.goforcode.invoicify.models;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.meanbean.test.BeanTester;


public class RateBasedBillingRecordTests {
	

	@Test
	public void test_all_gets_and_sets_for_rate_based_billing() {
		new BeanTester().testBean(RateBasedBillingRecord.class);
	}

	@Test 
	public void test_getTotal_returns_amount() {
		
		//Arrange
		RateBasedBillingRecord rateBasedBillingRecords = new RateBasedBillingRecord();
		rateBasedBillingRecords.setRate(3);
		rateBasedBillingRecords.setQuantity(2);
		
		//Act
		double billRecord = rateBasedBillingRecords.getTotal();
	
		
		assertThat(billRecord).isEqualTo(6);
	
	}
}
