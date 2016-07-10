package eshoptest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import ro.sit.eshop.CustomerDaoImpl;

public class TestEshop {
	CustomerDaoImpl customer = new CustomerDaoImpl();

	@Test
	public void CreateCustomerTest() {

		customer.createCustomer(1, "Bobo", "bobo@mail.com");
		assertEquals(1, customer.getcounter());

	}

}
