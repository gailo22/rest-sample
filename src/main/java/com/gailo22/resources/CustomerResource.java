package com.gailo22.resources;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gailo22.model.Address;
import com.gailo22.model.Contact;
import com.gailo22.model.Customer;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

	@GET
	@Path("{id}")
	public Customer getCustomer(@PathParam("id")
	String id) {
		Customer customer = new Customer();
		customer.setId(Integer.valueOf(id));

		List<Address> addresses = new LinkedList<Address>();
		Address address = new Address();
		address.setNumber(4);
		address.setCountry("Thailand");
		addresses.add(address);

		Address address2 = new Address();
		address2.setNumber(5);
		address2.setCountry("Malasia");
		addresses.add(address2);

		Contact contact = new Contact(1, "contact", addresses);
		customer.setContact(contact);

		return customer;

	}

	@POST
	public Response createCustomer(Customer customer) {
		System.out.println("customer : " + customer);
		return Response.status(200).entity(customer).build();
	}

}
