package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@RequestMapping("addAlien")
	public String home(Alien al)
	{
		repo.save(al);
		return "home.jsp";
	}
	
	@RequestMapping("getAlien")
	public ModelAndView alienfetch(@RequestParam int aid)
	{
		System.out.println("control reaches somewhere");
		ModelAndView mv = new ModelAndView("showalien.jsp");
		// orElse method returns the else part in case of no result from database.
		Alien al  = repo.findById(aid).orElse(new Alien());
		mv.addObject(al);
		
		// finding all the rows of the database
		System.out.println("Printing all the aliens");
		System.out.println(repo.findAll());
		
		// finding all the rows who technology is Java
		System.out.println("findByTech ");
		System.out.println(repo.findByTech("Java"));
		
		//finding all the tuples whose id is Greater than 103
		System.out.println("id who are greater than 103");
		System.out.println(repo.findByAidGreaterThan(103));
		
		// JPQL 
		System.out.println("alien who use java, Sorted by aname");
		System.out.println(repo.findByTechSorted("Java"));
		return mv;
	}
}
