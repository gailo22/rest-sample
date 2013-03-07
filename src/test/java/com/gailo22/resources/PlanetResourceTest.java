package com.gailo22.resources;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.Test;

import com.gailo22.model.Planet;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

public class PlanetResourceTest extends JerseyTest {

	public PlanetResourceTest() {
		super("com.gailo22.resources");
	}

	@Test
	public void shouldReturnPlanetInXmlFormat() {
		// Given
		WebResource resource = resource();

		// When
		Planet planet = resource.path("planet").get(Planet.class);
		
		// Then
		assertNotNull(planet);
		assertEquals(1, planet.id);
		assertEquals("Earth", planet.name);
		assertEquals(1.0, planet.radius);
		
	}
}
