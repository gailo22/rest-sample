package com.gailo22.resources;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

import com.gailo22.model.Customer;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

@Ignore
public class CustomerResourceTest extends JerseyTest {

	public CustomerResourceTest() {
		super("com.gailo22.resources");
	}

	@Test
	public void shouldReturnCorrectCustomer() {
		// Given
		WebResource resource = resource();

		// When
		Customer customer = resource.path("customers/1").get(Customer.class);

		// Then
		assertNotNull(customer);
		assertEquals(1, customer.getId());
	}

	@Test
	public void shouldCreateCustomer() {
		// Given
		WebResource resource = resource();
		Customer customer = new Customer();
		customer.setId(2);

		// When
		Customer returnCustomer = resource.path("customers").post(Customer.class, customer);

		// Then
		assertEquals(2, returnCustomer.getId());
	}
}
