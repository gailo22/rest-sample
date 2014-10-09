package com.gailo22.resources;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.gailo22.GrizzlyServerFixture;
import com.gailo22.model.Customer;

@Ignore
public class CustomerResourceTest {

    private HttpServer server;
    private WebTarget target;
    
    @Before
    public void setUp() throws Exception {
        // start the server
        server = GrizzlyServerFixture.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(GrizzlyServerFixture.BASE_URI);
    }
    
    @After
    public void tearDown() throws Exception {
        server.shutdownNow();
    }

	@Test
	public void shouldReturnCorrectCustomer() {
		// Given

		// When
		Customer customer = target.path("customers/1").request().get(Customer.class);

		// Then
		assertNotNull(customer);
		assertEquals(1, customer.getId());
	}

	@Test
	public void shouldCreateCustomer() {
		// Given
		Customer customer = new Customer();
		customer.setId(2);

		// When
		Customer returnCustomer = target.path("customers").request().post(
				Entity.entity(customer, "application/json"), Customer.class);

		// Then
		assertEquals(2, returnCustomer.getId());
	}
}
