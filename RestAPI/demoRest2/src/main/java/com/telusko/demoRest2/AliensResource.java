package com.telusko.demoRest2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AliensResource {

	// @GET
	// @Produces(MediaType.APPLICATION_XML)
	// public List<Alien> getAlien()
	// {
	// Alien a1= new Alien();
	// a1.setId(101);
	// a1.setName("Jadoo");
	// a1.setPoints(70);
	//
	// Alien a2= new Alien();
	// a2.setId(102);
	// a2.setName("Abbott");
	// a2.setPoints(110);
	//
	//
	// List<Alien> li = new ArrayList<Alien>();
	// li.add(a1);
	// li.add(a2);
	//
	// return li;
	// }

	static AlienRepository repo = new AlienRepository();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAlien() 
	{
		System.out.println("List<Alien> getAlien() ");
		return repo.getaliens();
	}

	@POST
	@Path("alien")
	public Alien createAlien(Alien a1) {
		System.out.println(a1);
		repo.create(a1);

		// for(Alien a: repo.getaliens())
		// {
		// System.out.println(a);
		// }
		System.out.println("RepoSize is " + repo.getaliens().size());

		return a1;
	}
	

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("alien/{id}") // place holder {id} will be paced in function
	public Alien getSpecificAlien(@PathParam("id") int id)  // We will another annotation PathParan here which passes the id
	{
		return repo.getalien(id);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("alienJSON/{id}") // place holder {id} will be paced in function
	public Alien getSpecificAlienJSON(@PathParam("id") int id)  // We will another annotation PathParan here which passes the id
	{
		return repo.getalien(id);
	}
	
	
}
