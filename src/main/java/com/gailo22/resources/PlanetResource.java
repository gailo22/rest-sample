package com.gailo22.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gailo22.model.Planet;

@Path("/planet")
public class PlanetResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Planet getPlanet() {
		Planet p = new Planet();
		p.id = 1;
		p.name = "Earth";
		p.radius = 1.0;

		return p;
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void setPlanet(Planet p) {
		System.out.println("setPlanet " + p);
	}

}
