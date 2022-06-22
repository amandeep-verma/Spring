package com.telusko;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AlienResource {

	@Autowired
	AlienRepository repo;
	
//	@RequestMapping(value = "aliens", method = RequestMethod.GET)
	@GetMapping("aliens")
	public List<Alien> getAliens()
	{
		List<Alien> aliens = (List<Alien>) repo.findAll();
		return aliens;
	}	
}
