package com.telusko.demoRest1;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	List<Alien> li;
	
	public AlienRepository() {
		li = new ArrayList<Alien>();
		
		Alien a1= new Alien();
		a1.setId(101);
		a1.setName("Jadoo");
		a1.setPoints(70);
		
		Alien a2= new Alien();
		a2.setId(102);
		a2.setName("Abbott");
		a2.setPoints(110);
		
		li.add(a1);
		li.add(a2);
	}
	
	public List<Alien> getaliens()
	{
		return li;
	}
	
	
	public Alien getalien(int id)
	{
		Alien a1 = null;
		for(Alien a:li)
		{
			if(a.getId() == id)
				return a;
		}
		
		return a1;
	}

	public void create(Alien a1) {
		li.add(a1);
		
	}
	
}
