package com.telusko.demoRest2;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("aliens")
public class AliensResource {

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
	
	
	@PUT
	@Path("alien")
	public Alien updateAlien(Alien a1) {
		System.out.println(a1);
		repo.update(a1);

		return a1;
	}
	
	@DELETE
	@Path("alien/{id}")
	public Alien deleteAlien(@PathParam("id") int id) {
		Alien a = repo.getalien(id);
		
		if(a.getId()!=0)
			repo.delete(id);

		return a;
	}
	
}
