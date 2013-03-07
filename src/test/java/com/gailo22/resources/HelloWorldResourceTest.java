package com.gailo22.resources;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

public class HelloWorldResourceTest extends JerseyTest {

	public HelloWorldResourceTest() {
		super("com.gailo22.resources");
	}

	@Test
	public void shouldReturnHelloWorldMessage() {
		// Given
		WebResource resource = resource();

		// When
		String responseMessage = resource.path("helloworld").get(String.class);

		// Then
		assertEquals("Hello world", responseMessage);
	}

}
