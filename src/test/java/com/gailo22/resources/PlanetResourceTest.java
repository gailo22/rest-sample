package com.gailo22.resources;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gailo22.GrizzlyServerFixture;
import com.gailo22.model.Planet;

public class PlanetResourceTest {

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
	public void shouldReturnPlanetInXmlFormat() {
		// Given

		// When
		Planet planet = target.path("planet").request().get(Planet.class);
		
		// Then
		assertNotNull(planet);
		assertEquals(1, planet.id);
		assertEquals("Earth", planet.name);
		assertEquals(1.0, planet.radius);
		
	}
}
