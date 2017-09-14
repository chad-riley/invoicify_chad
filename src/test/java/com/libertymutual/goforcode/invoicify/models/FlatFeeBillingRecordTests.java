package com.libertymutual.goforcode.invoicify.models;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;


public class FlatFeeBillingRecordTests {

	@Test
	public void test_all_gets_and_sets_for_flat_fee_billing() {
		BeanTester tester = new BeanTester();
		Configuration configuration = new ConfigurationBuilder()
			.ignoreProperty("createdOn")
			.build();
		tester.testBean(FlatFeeBillingRecords.class, configuration);
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

