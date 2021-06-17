package com.telusko.demoRest2;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("alien")
public class AlienResource {

	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Alien getAlien()
	{
		
		Alien a1= new Alien();
		a1.setId(101);
		a1.setName("Jadoo");
		a1.setPoints(70);
		
		return a1;
	}
	
	
}
